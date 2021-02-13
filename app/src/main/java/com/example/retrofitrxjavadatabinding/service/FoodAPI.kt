package com.example.retrofitrxjavadatabinding.service

import com.example.retrofitrxjavadatabinding.model.Food
import io.reactivex.Single
import retrofit2.http.GET

interface FoodAPI {

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getFoodData() : Single<List<Food>>
}