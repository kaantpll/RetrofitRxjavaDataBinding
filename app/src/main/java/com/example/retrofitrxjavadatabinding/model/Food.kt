package com.example.retrofitrxjavadatabinding.model

import com.google.gson.annotations.SerializedName

data class Food (
    @SerializedName("isim")
    val foodName : String,

    @SerializedName("kalori")
    val foodCalories : String,

    @SerializedName("gorsel")
    val imageUrl : String,

    )