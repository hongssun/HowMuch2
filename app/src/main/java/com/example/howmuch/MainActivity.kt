package com.example.howmuch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.howmuch.ui.ItemlistFragment
import com.example.howmuch.ui.MylistFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_itemlist.*

class MainActivity : AppCompatActivity(){
    val itemRepository = arrayListOf(
        ItemData("마우스",1000),
        ItemData("키보드",5000),
        ItemData("냉장고",325000),
        ItemData("마이크",5000),
        ItemData("마우스",1000),
        ItemData("키보드",5000),
        ItemData("냉장고",325000),
        ItemData("마이크",5000),
        ItemData("마우스",1000),
        ItemData("키보드",5000),
        ItemData("냉장고",325000),
        ItemData("마이크",5000),
        ItemData("마우스",1000),
        ItemData("키보드",5000),
        ItemData("냉장고",325000),
        ItemData("마이크",5000),
        ItemData("오징어",5000)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*val bottomNavigationView = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigationView?.setOnNavigationItemSelectedListener(this)*/

        //없어도 되는 코드
        NavigationUI.setupWithNavController(
            bottom_navigation, findNavController(R.id.navigation_host)
        )




    }
}
