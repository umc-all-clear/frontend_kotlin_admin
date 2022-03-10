package com.choi.clear_admin.data.entity

data class GetReqResult(
    var isSuccess:Boolean? = false,
    var code:Int? = 0,
    var message: String? = null,
    var result: String? = null
)
