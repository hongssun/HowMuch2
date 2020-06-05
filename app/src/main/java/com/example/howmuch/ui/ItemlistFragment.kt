package com.example.howmuch.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.howmuch.ItemAdapter
import com.example.howmuch.MainActivity
import com.example.howmuch.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_itemlist.view.*

class ItemlistFragment : Fragment()  {

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
    private fun loadFragment(fragment : Fragment){
        val fragManager: FragmentManager? = fragmentManager
        fragManager?.beginTransaction().also{ fragmentTransaction ->
            fragmentTransaction?.replace(R.id.fragmentContainer, fragment)?.commit()
        }
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)

        val list =            view?.findViewById(R.id.bottom_navigation) as BottomNavigationView

        loadFragment(ItemlistFragment())
        list.setOnNavigationItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.itemlistFragment -> {
                    loadFragment(ItemlistFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.mylistFragment -> {
                    loadFragment(MylistFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }

            }

        }

    }
}
