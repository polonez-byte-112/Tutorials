package com.practice.room.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.practice.room.R
import com.practice.room.model.User
import kotlinx.android.synthetic.main.my_row.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.my_row, parent,false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = userList[position]
        holder.itemView.myId.text = currentItem.id.toString();
        holder.itemView.myFirstname.text= currentItem.firstName
        holder.itemView.myLastname.text= currentItem.secondName
        holder.itemView.myAge.text= currentItem.age.toString()

        holder.itemView.rowLayout.setOnClickListener {
            val actrion = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(actrion)
        }
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


    fun setData(user: List<User>){
        this.userList=user
        //uzywa,y to nizej bo array moze sie zmienic etc 
        notifyDataSetChanged()
    }


}