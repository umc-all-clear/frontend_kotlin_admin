package com.choi.clear_admin.data.remote

import com.choi.clear_admin.ui.view.CommView
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroService {
    lateinit var commView: CommView

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

    }
}