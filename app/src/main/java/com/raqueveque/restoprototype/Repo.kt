package com.raqueveque.restoprototype

import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Repo {
    fun getFoodData(): MutableLiveData<MutableList<Food>>{
        val dataMutable = MutableLiveData<MutableList<Food>>()
        FirebaseDatabase.getInstance().getReference("comida")
            .addValueEventListener(object : ValueEventListener{
                val listData = mutableListOf<Food>()
                override fun onDataChange(p0: DataSnapshot) {
                    if (p0.exists()){
                        for (foodSnapshot in p0.children){
                            val food = foodSnapshot.getValue(Food::class.java)
                            listData.add(food!!)
                        }
                    }
                    dataMutable.value = listData
                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        return dataMutable
    }

}
