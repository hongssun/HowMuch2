package com.example.howmuch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class ItemAdapter(val items: ArrayList<ItemData>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    override fun getItemCount() = items.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)

        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }


    inner class ViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        fun bindItem(items : ItemData){
            item.name_tv.text = items.ItemName
            item.price_tv.text = items.ItemPrice.toString()
            item.img_res.setImageResource(items.imgRes)
            item.setOnClickListener{
                val bundle = Bundle().apply { putInt("idx", position) }

                Navigation.findNavController(item).navigate(R.id.action_itemlistFragment_to_listdetailFragment, bundle)
            }

        }
    }
}