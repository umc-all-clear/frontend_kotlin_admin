package com.choi.clear_admin.data.entity

data class Result (
        var id: Int? = 0,
        var cleanedTime: String? = null,
        var userEmail: String? = null,
        var score: Double? = 0.0,
        var contents: String? = null,
        var comments: Any? = null,
        var beforePicUrl: String? = null,
        var afterPicUrl: String? = null,
        var isWaited: Boolean? = false
)

data class GetCommResult (
        var isSuccess:Boolean? = false,
        var code: Int? = 0,
        var message: String? = null,
        var result: ArrayList<Result>? = null
        )