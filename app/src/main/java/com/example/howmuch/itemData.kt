package com.example.howmuch

import androidx.annotation.DrawableRes

data class ItemData(
    @DrawableRes val imgRes : Int,
    val ItemName : String,
    val ItemPrice : Int

)