package com.choi.clear_admin.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.choi.clear_admin.data.entity.*
import com.choi.clear_admin.data.remote.RetroService
import com.choi.clear_admin.databinding.ActivityMainBinding
import com.choi.clear_admin.ui.adapter.commRVAdapter
import com.choi.clear_admin.ui.adapter.friendRVAdapter

class MainActivity : AppCompatActivity(), CommView, ReqView, FriendView {
    lateinit var binding: ActivityMainBinding
    lateinit var commAdapter: commRVAdapter
    lateinit var friendAdapter: friendRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var tempList =  ArrayList<Result>()
        tempList.add(Result(0, "", "", 0.0, "","","", "", true))
        commAdapter = commRVAdapter(tempList, this)
        binding.mainCommRv.adapter = commAdapter

        var tempList2 = ArrayList<FriendResult>()
        tempList2.add(FriendResult(0, "", "", "", null))
        friendAdapter = friendRVAdapter(tempList2)
        binding.mainFriendRv.adapter = friendAdapter

        initListener()
        initCommData()
    }

    fun initCommData() {
        val serve = RetroService
        serve.commView = this
        serve.reqComm()
    }

    fun initListener() {
        binding.commIv.setOnClickListener {
            binding.mainCommRv.visibility = View.VISIBLE
            binding.mainFriendRv.visibility = View.GONE

            initCommData()
        }

        binding.friendIv.setOnClickListener {
            binding.mainCommRv.visibility = View.GONE
            binding.mainFriendRv.visibility = View.VISIBLE

            val conn = RetroService
            conn.friendView = this
            conn.reqFriend()
        }

        commAdapter.setOnclick(object : commRVAdapter.setOnClickListener {
            override fun setOnClick(idx: Int, score: Float, comm: String, pos: Int) {
                val conn = RetroService
                conn.reqView = this@MainActivity
                conn.reqSubmitComm(ReqComm(idx, score, comm), pos)
            }

        })
    }

    override fun onCommGetSuccess(data: GetCommResult) {
        val dataArr = data.result
        commAdapter.dataArr = dataArr!!
        commAdapter.notifyDataSetChanged()
    }

    override fun onCommGetFailure(code: String) {
    }

    override fun onReqGetSuccess(data: GetReqResult, pos: Int) {
        Toast.makeText(this, "평가 완료", Toast.LENGTH_SHORT).show()
        var origin = commAdapter.dataArr
        origin.removeAt(pos)

        commAdapter.dataArr = origin
        commAdapter.notifyItemRemoved(pos)
    }

    override fun onReqGetFailure(code: String) {
    }

    override fun onFriendGetSuccess(data: GetFriend) {
        val dataArr = data.result
        friendAdapter.dataArr = dataArr!!
        friendAdapter.notifyDataSetChanged()
    }

    override fun onFriendGetFailure(code: Int) {
    }
}