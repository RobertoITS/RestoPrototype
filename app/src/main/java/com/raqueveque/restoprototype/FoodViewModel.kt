package com.raqueveque.restoprototype

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodViewModel: ViewModel(){
    private val repo = Repo()
    fun fetchFoodData(): LiveData<MutableList<Food>>{
        val mutableData = MutableLiveData<MutableList<Food>>()
        repo.getFoodData().observeForever {foodList ->
            mutableData.value = foodList
        }
        return mutableData
    }
}