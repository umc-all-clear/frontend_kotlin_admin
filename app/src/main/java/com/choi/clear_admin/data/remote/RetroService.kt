package com.choi.clear_admin.data.remote

import com.choi.clear_admin.data.entity.GetCommResult
import com.choi.clear_admin.data.entity.GetFriend
import com.choi.clear_admin.data.entity.GetReqResult
import com.choi.clear_admin.data.entity.ReqComm
import com.choi.clear_admin.ui.view.CommView
import com.choi.clear_admin.ui.view.FriendView
import com.choi.clear_admin.ui.view.ReqView
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroService {
    lateinit var commView: CommView
    lateinit var reqView: ReqView
    lateinit var friendView: FriendView

    fun makeRetrofit(): Retrofit {
        val clientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(loggingInterceptor)

        val retrofit = Retrofit.Builder().baseUrl("http://3.35.26.181/").addConverterFactory(
            GsonConverterFactory.create()).client(clientBuilder.build()).build()

        return retrofit
    }

    fun reqComm() {
        val retro = makeRetrofit()
        val service = retro.create(RetroServiceInterface::class.java)

        val call = service.setComm()

        call.enqueue(object: retrofit2.Callback<GetCommResult> {
            override fun onResponse(call: Call<GetCommResult>, response: Response<GetCommResult>) {
                if (response.isSuccessful) {
                    commView.onCommGetSuccess(response.body()!!)
                }
                else {
                    commView.onCommGetFailure(response.message())
                }
            }

            override fun onFailure(call: Call<GetCommResult>, t: Throwable) {
            }

        })
    }

    fun reqSubmitComm(req: ReqComm, pos: Int) {
        val retro = makeRetrofit()
        val service = retro.create(RetroServiceInterface::class.java)

        val call = service.reqComm(req)

        call.enqueue(object :retrofit2.Callback<GetReqResult> {
            override fun onResponse(call: Call<GetReqResult>, response: Response<GetReqResult>) {
                if (response.isSuccessful) {
                    reqView.onReqGetSuccess(response.body()!!, pos)
                }
                else {
                    reqView.onReqGetFailure(response.body().toString())
                }
            }

            override fun onFailure(call: Call<GetReqResult>, t: Throwable) {
            }

        })

    }

    fun reqFriend() {
        val retro = makeRetrofit()
        val service = retro.create(RetroServiceInterface::class.java)

        val call = service.reqFriend()

        call.enqueue(object: retrofit2.Callback<GetFriend>{
            override fun onResponse(call: Call<GetFriend>, response: Response<GetFriend>) {
                if (response.isSuccessful) {
                    friendView.onFriendGetSuccess(response.body()!!)
                }
                else {
                    friendView.onFriendGetFailure(response.code()!!)
                }
            }

            override fun onFailure(call: Call<GetFriend>, t: Throwable) {
            }

        })
    }
}