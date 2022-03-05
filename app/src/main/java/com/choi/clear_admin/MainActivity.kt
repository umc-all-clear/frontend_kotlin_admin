package com.choi.clear_admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.choi.clear_admin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init() {
        binding.commIv.setOnClickListener {
            binding.mainCommRv.visibility = View.VISIBLE
            binding.mainFriendRv.visibility = View.GONE
        }

        binding.friendIv.setOnClickListener {
            binding.mainCommRv.visibility = View.GONE
            binding.mainFriendRv.visibility = View.VISIBLE
        }


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
        binding.mainCommRv.adapter = commRVAdapter(arr)
        binding.mainFriendRv.adapter = friendRVAdapter(arr)
    }
}