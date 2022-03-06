package com.choi.clear_admin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.choi.clear_admin.databinding.ItemMainFriendBinding

class friendRVAdapter (val data: ArrayList<Int>): RecyclerView.Adapter<friendRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMainFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.init()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(val binding: ItemMainFriendBinding): RecyclerView.ViewHolder(binding.root) {
        fun init() {

        }
    }
}