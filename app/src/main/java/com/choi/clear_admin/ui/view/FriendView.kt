package com.choi.clear_admin.ui.view

import com.choi.clear_admin.data.entity.GetFriend

interface FriendView {
    fun onFriendGetSuccess(data: GetFriend)
    fun onFriendGetFailure(code: Int)
}