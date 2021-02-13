package com.example.retrofitrxjavadatabinding.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitrxjavadatabinding.model.Food
import com.example.retrofitrxjavadatabinding.service.FoodAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val foodApiService = FoodAPIService()

    val foodList = MutableLiveData<List<Food>>()


    fun fecthData(){
        compositeDisposable.add(

            foodApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<List<Food>>(){
                    override fun onSuccess(t: List<Food>) {
                        foodList.value = t

                    }

                    override fun onError(e: Throwable) {
                       e.printStackTrace()
                    }

                }
        ))

        //compositeDisposable.clear()
    }



}