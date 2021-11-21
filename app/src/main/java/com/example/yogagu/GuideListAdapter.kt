package com.example.yogagu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GuideListAdapter(wordList: List<Guide?>?) : RecyclerView.Adapter<GuideListAdapter.MyViewHolder>() {
    private lateinit var guideList: List<Guide>
    fun setUserList(wordsList: List<Guide>) {
        guideList = wordsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewGuide.text = guideList[position].name
        holder.textViewGuide2.text = guideList[position].content
        holder.textViewGuide3.text = guideList[position].visible
    }

    override fun getItemCount(): Int {
        return guideList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewGuide: TextView
        var textViewGuide2: TextView
        var textViewGuide3: TextView

        init {
            textViewGuide = view.findViewById(R.id.textViewHeader)
            textViewGuide2 = view.findViewById(R.id.textViewContent)
            textViewGuide3 = view.findViewById(R.id.textViewVisible)
        }
    }

    companion object {
        var db: MyDatabase? = null
    }

//    init {
//        guideList = guideList
//    }
}