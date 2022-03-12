package com.choi.clear_admin.data.entity

import java.sql.Timestamp

data class GetFriend(
    var isSuccess: Boolean? = null,
    var code: Int? = null,
    var message: String? = null,
    var result: ArrayList<FriendResult>? = null

)
data class FriendResult (
    var id: Int = 0,
    var nickname: String = "",
    var email: String = "",
    var password: String = "",
    var createdAt: Timestamp? = null
    )