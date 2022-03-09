package com.choi.clear_admin.data.remote

import com.choi.clear_admin.data.entity.GetCommResult
import com.choi.clear_admin.data.entity.ReqCommData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface RetroServiceInterface {
    @POST("/admin/unchecked")
    fun setComm(): Call<GetCommResult>
}