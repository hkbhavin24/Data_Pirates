package com.example.datapirates.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.datapirates.Database.RoomDB
import com.example.datapirates.Database.TaskEntity
import com.example.datapirates.R

class taskadepter(list: List<TaskEntity>) : RecyclerView.Adapter<taskadepter.TaskHolder>() {
    var list = list
    lateinit var db: RoomDB
    lateinit var context: Context

    class TaskHolder(itemview: View) : ViewHolder(itemview) {
        var txtTitle = itemview.findViewById<TextView>(R.id.txttitle)
        var txtdiscription = itemview.findViewById<TextView>(R.id.txtdiscription)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        context = parent.context
        return TaskHolder(
            LayoutInflater.from(parent.context).inflate((R.layout.taskitem), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        db=RoomDB.getInstance(context)
        holder.txtTitle.text=list.get(position).title
        holder.txtdiscription.text=list.get(position).description
    }
}