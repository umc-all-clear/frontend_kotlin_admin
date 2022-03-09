package com.choi.clear_admin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.choi.clear_admin.data.entity.Result
import com.choi.clear_admin.databinding.ItemMainCommBinding
import com.choi.clear_admin.ui.view.MainActivity
import java.lang.NumberFormatException

class commRVAdapter(dataArr: ArrayList<Result>, val act: MainActivity): RecyclerView.Adapter<commRVAdapter.ViewHolder>() {

    lateinit var onClick: setOnClickListener
    var dataArr: ArrayList<Result> = dataArr

    interface setOnClickListener {
        fun setOnClick(idx: Int, score: Float, comm: String)
    }

    fun setOnclick(setting: setOnClickListener) {
        onClick = setting
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMainCommBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.init(position)
    }

    override fun getItemCount(): Int {
        return dataArr.size
    }

    inner class ViewHolder(val binding: ItemMainCommBinding): RecyclerView.ViewHolder(binding.root) {
        fun init(pos: Int) {
            binding.itemDateTv.text = dataArr[pos].cleanedTime
            Glide.with(act).load(dataArr[pos].beforePicUrl).into(binding.itemBeforeIv)
            Glide.with(act).load(dataArr[pos].afterPicUrl).into(binding.itemAfterIv)
            binding.itemFedTv.text = dataArr[pos].contents

            setListener(pos)
        }

        fun setListener(pos: Int) {
            binding.itemAdminSubmitBtn.setOnClickListener {
                var scoreErr = false
                var comm = ""
                var score = 0.00f
                try {
                    var score = binding.itemAdminScoreEt.text.toString().toFloat()
                } catch (e: NumberFormatException) {
                    scoreErr = true
                }
                comm = binding.itemAdminCommEt.text.toString()

                if (comm != "" && scoreErr == false) {
                    onClick.setOnClick(dataArr[pos].id!!, score, comm)
                }
            }
        }
    }
}