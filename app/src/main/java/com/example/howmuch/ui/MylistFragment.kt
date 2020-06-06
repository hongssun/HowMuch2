package com.example.howmuch.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.howmuch.ItemAdapter
import com.example.howmuch.MainActivity
import com.example.howmuch.MyItemAdapter
import com.example.howmuch.R
import kotlinx.android.synthetic.main.fragment_itemlist.*
import kotlinx.android.synthetic.main.fragment_itemlist.view.*
import kotlinx.android.synthetic.main.fragment_mylist.*
import kotlinx.android.synthetic.main.fragment_mylist.view.*
import kotlinx.android.synthetic.main.fragment_mylist.view.bottom_navigation2


class MylistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mylist, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val items = (requireContext() as MainActivity).itemRepository

        view?.let{
            it.myItem_rv?.adapter = MyItemAdapter(items)
            it.myItem_rv?.layoutManager = LinearLayoutManager(requireContext())
        }
        NavigationUI.setupWithNavController(
            bottom_navigation2,
            requireActivity().findNavController(R.id.navigation_host)
        )
    }
}
