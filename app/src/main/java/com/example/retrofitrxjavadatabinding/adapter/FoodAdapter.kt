package com.example.retrofitrxjavadatabinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitrxjavadatabinding.R
import com.example.retrofitrxjavadatabinding.databinding.CardItemBinding
import com.example.retrofitrxjavadatabinding.model.Food

class FoodAdapter(var foodList : ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {

    class MyViewHolder(var view : CardItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<CardItemBinding>(inflater,R.layout.card_item,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.myApp = foodList[position]
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun updateList(newList : ArrayList<Food>){
        foodList.clear()
        foodList.addAll(newList)
        notifyDataSetChanged()
    }
}