package com.example.howmuch.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.howmuch.ItemAdapter
import com.example.howmuch.MainActivity
import com.example.howmuch.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_itemlist.*
import kotlinx.android.synthetic.main.fragment_itemlist.view.*

class ItemlistFragment : Fragment()  {
    //var list = view?.findViewById(R.id.bottom_navigation) as BottomNavigationView

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

        NavigationUI.setupWithNavController(
            bottom_navigation1,
            requireActivity().findNavController(R.id.navigation_host)
        )
    }

}
