package com.example.datapirates.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.datapirates.Database.TaskEntity
import com.example.datapirates.R

class CategoryAdapter(list: List<TaskEntity>) : Adapter<CategoryAdapter.CategoryHolder>() {

    var list = list
    class CategoryHolder(itemView: View) : ViewHolder(itemView){
     var cat = itemView.findViewById<TextView>(R.id.tvCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_list,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.cat.text = list[position].category
    }
}