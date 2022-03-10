package com.choi.clear_admin.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.choi.clear_admin.data.entity.GetCommResult
import com.choi.clear_admin.data.entity.GetReqResult
import com.choi.clear_admin.data.entity.ReqComm
import com.choi.clear_admin.data.entity.Result
import com.choi.clear_admin.data.remote.RetroService
import com.choi.clear_admin.databinding.ActivityMainBinding
import com.choi.clear_admin.ui.adapter.commRVAdapter
import com.choi.clear_admin.ui.adapter.friendRVAdapter

class MainActivity : AppCompatActivity(), CommView, ReqView {
    lateinit var binding: ActivityMainBinding
    lateinit var commAdapter: commRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tempList =  ArrayList<Result>()
        tempList.add(Result(0, "", "", 0.0, "","","", "", true))
        commAdapter = commRVAdapter(tempList, this)
        binding.mainCommRv.adapter = commAdapter
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
        }

        commAdapter.setOnclick(object : commRVAdapter.setOnClickListener {
            override fun setOnClick(idx: Int, score: Float, comm: String, pos: Int) {
                val conn = RetroService
                conn.reqView = this@MainActivity
                conn.reqSubmitComm(ReqComm(idx, score, comm), pos)
            }

        })

        val arr = ArrayList<Int>()
        arr.add(1)
        arr.add(1)
        arr.add(1)
        arr.add(1)
        arr.add(1)
        arr.add(1)
        arr.add(1)
        arr.add(1)
        arr.add(1)
        binding.mainFriendRv.adapter = friendRVAdapter(arr)
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
}