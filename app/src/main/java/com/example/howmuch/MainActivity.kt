package com.example.howmuch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.howmuch.ui.ItemlistFragment
import com.example.howmuch.ui.MylistFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_itemlist.*


class MainActivity : AppCompatActivity(){
    val itemRepository = arrayListOf(
        ItemData(R.drawable.ball1,"농구공",1000),
        ItemData(R.drawable.bicycle1,"자전거",5000),
        ItemData(R.drawable.cosmetics1,"화장품",325000),
        ItemData(R.drawable.cube1,"큐브",5000),
        ItemData(R.drawable.cup1,"컵",1000),
        ItemData(R.drawable.doll1,"인형",5000),
        ItemData(R.drawable.earphones1,"이어폰",325000),
        ItemData(R.drawable.hat1,"모자",5000),
        ItemData(R.drawable.pan1,"선풍기",1000),
        ItemData(R.drawable.phone1,"핸드폰",5000),
        ItemData(R.drawable.shirt1,"셔츠",325000),
        ItemData(R.drawable.shoes1,"신발",5000),
        ItemData(R.drawable.stove1,"오븐",1000),
        ItemData(R.drawable.toy1,"장난감",5000),
        ItemData(R.drawable.umbrella1,"우산",325000),
        ItemData(R.drawable.wallet1,"지갑",5000),
        ItemData(R.drawable.watch1,"시계",5000)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*loadFragment(ItemlistFragment())

        bottom_navigation.setOnNavigationItemSelectedListener {menuItem ->
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

        }*/
    }
    private fun loadFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().also{fragmentTransaction ->
            fragmentTransaction.replace(R.id.fragmentContainer, fragment).commit()
        }
    }
}
