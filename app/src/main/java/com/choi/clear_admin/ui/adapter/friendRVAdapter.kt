package com.choi.clear_admin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.choi.clear_admin.data.entity.FriendResult
import com.choi.clear_admin.databinding.ItemMainFriendBinding

class friendRVAdapter (data: ArrayList<FriendResult>): RecyclerView.Adapter<friendRVAdapter.ViewHolder>() {

    var dataArr = data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMainFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.init(position)
    }

    override fun getItemCount(): Int {
        return dataArr.size
    }

    inner class ViewHolder(val binding: ItemMainFriendBinding): RecyclerView.ViewHolder(binding.root) {
        fun init(pos: Int) {
            binding.friendDate.text = "created: " + dataArr[pos].createdAt.toString()
            binding.friendId.text = "id: " + dataArr[pos].email
            binding.friendNic.text = "nick: " + dataArr[pos].nickname
            binding.friendPas.text = "password: " +dataArr[pos].password
        }
    }
}