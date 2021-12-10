package com.raqueveque.restoprototype

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.borjabravo.readmoretextview.ReadMoreTextView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init

class FoodAdapter (private val context: Context): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private var dataList = mutableListOf<Food>()

    fun setListData(data: MutableList<Food>){
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_card, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bindView(currentItem)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", currentItem.name)
            bundle.putString("description", currentItem.description)
            bundle.putString("image", currentItem.image)
            bundle.putString("price", currentItem.price)
            DetailsFragment().arguments = bundle
            
        }
    }

    override fun getItemCount(): Int {
        return if (dataList.size > 0){
            dataList.size
        } else {
            0
        }
    }

    inner class FoodViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(food: Food){
            val description: String = food.description
            val name: String = food.name
            val price: String = food.price
            val imageUrl: String = food.image
            itemView.findViewById<ReadMoreTextView>(R.id.description).text = description
            itemView.findViewById<TextView>(R.id.name).text = name
            itemView.findViewById<TextView>(R.id.price).text = price
            val image = itemView.findViewById<ImageView>(R.id.image)
            Glide.with(context).load(imageUrl).into(image)
        }
    }

//    interface OnItemClickListener{
//        fun onItemClick(position: Int, name: String, desciption: String, image: String, price: String)
//    }
//    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener){
//        mlistener = listener
//    }
}