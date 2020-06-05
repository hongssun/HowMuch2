package com.example.howmuch.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.howmuch.ItemAdapter
import com.example.howmuch.MainActivity
import com.example.howmuch.R
import kotlinx.android.synthetic.main.fragment_itemlist.*
import kotlinx.android.synthetic.main.fragment_itemlist.view.*
import androidx.navigation.fragment.findNavController

import kotlinx.android.synthetic.main.fragment_itemlist.*

class ItemlistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_itemlist, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val items = (requireContext() as MainActivity).itemRepository
        view?.let{
            it.message_rv.adapter = ItemAdapter(items)
            it.message_rv.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}
