package com.example.yogagu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 * Created by Juned on 8/9/2017.
 */
class FirebaseListAdapter(private val context: Context, private val list: ArrayList<FirebaseGuide>) : RecyclerView.Adapter<FirebaseListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val guide = list[position]
        holder.description.text = guide.description
        holder.title.text = guide.title
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var description: TextView
        var title: TextView
        var id: TextView? = null

        init {
            description = view.findViewById(R.id.textViewContent)
            title = view.findViewById(R.id.textViewHeader)
        }
    }
}