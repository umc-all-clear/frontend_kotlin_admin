package com.choi.clear_admin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.choi.clear_admin.databinding.ItemMainCommBinding

class commRVAdapter(val data: ArrayList<Int>): RecyclerView.Adapter<commRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMainCommBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.init()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(val binding: ItemMainCommBinding): RecyclerView.ViewHolder(binding.root) {
        fun init() {

        }
    }
}