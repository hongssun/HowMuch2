package com.example.howmuch

import androidx.annotation.DrawableRes

data class Add_itemData(
    @DrawableRes
    val AddimgRes : Int,
    val AddItemName : String,
    val AddItemPrice : Int,
    val AddItemExplain : String
)