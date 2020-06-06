package com.example.howmuch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_mylistdetail.view.*
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.android.synthetic.main.myitem_list.view.*

class MyItemAdapter(val items: ArrayList<ItemData>) : RecyclerView.Adapter<MyItemAdapter.ViewHolder>(){


    override fun getItemCount() = items.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.myitem_list, parent, false)

        return ViewHolder(rootView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])

    }

    inner class ViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        fun bindItem(items : ItemData){
            item.myname_tv.text = items.ItemName
            item.myprice_tv.text = items.ItemPrice.toString()
            item.myimg_res.setImageResource(items.imgRes)

            item.setOnClickListener{
                val bundle = Bundle().apply { putInt("idx", position) }

                Navigation.findNavController(item).navigate(R.id.action_mylistFragment_to_mylistdetailFragment, bundle)


            }

        }
    }
}