package com.choi.clear_admin.data.remote

import com.choi.clear_admin.data.entity.GetCommResult
import com.choi.clear_admin.data.entity.GetReqResult
import com.choi.clear_admin.data.entity.ReqComm
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST

interface RetroServiceInterface {
    @POST("/admin/unchecked")
    fun setComm(): Call<GetCommResult>

    @PATCH("/admin/evaluate")
    fun reqComm(@Body req: ReqComm): Call<GetReqResult>
}