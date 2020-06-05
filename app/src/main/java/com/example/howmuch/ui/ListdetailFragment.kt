package com.example.howmuch.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.howmuch.*
import kotlinx.android.synthetic.main.fragment_itemlist.view.*
import kotlinx.android.synthetic.main.fragment_listdetail.*
import kotlinx.android.synthetic.main.fragment_listdetail.view.*
import kotlinx.android.synthetic.main.fragment_mylist.view.*

/**
 * A simple [Fragment] subclass.
 */
class ListdetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_listdetail, container, false)

        add_list_btn.setOnClickListener  {
            val items = (requireContext() as MainActivity).itemRepository
            it?.let{
                it.myItem_rv.adapter = MyItemAdapter(items)
                it.myItem_rv.layoutManager = LinearLayoutManager(requireContext())
            }
        }

        return root
    }
    
    
    //리스트 클릭하면 꺼짐
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        
        super.onActivityCreated(savedInstanceState)
        arguments?.getInt("idx")?.let{
            (requireContext() as MainActivity).itemRepository.getOrNull(it)?.let{
                 bindItem(it)
            }
        }
    }

    private fun bindItem(item: ItemData){
        view?.let{
            it.detail_img.setImageResource(item.imgRes)
            it.detail_price_tv.text = "가격  : "  + item.ItemPrice.toString() + "원"
            it.detail_name_tv.text = "상품명 :  " + item.ItemName
        }
    }
}
