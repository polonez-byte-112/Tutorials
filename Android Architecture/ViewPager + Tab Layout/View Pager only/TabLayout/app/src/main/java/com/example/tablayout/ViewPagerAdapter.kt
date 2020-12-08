package com.example.tablayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter(val texts: Array<String>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPageViewHolder>() {
//Ctrl +i implementuje

    inner class ViewPageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent,false)
        return ViewPageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPageViewHolder, position: Int) {
        holder.itemView.displayedText.setText(texts[position])
    }

    override fun getItemCount(): Int {
            return texts.size
    }
}