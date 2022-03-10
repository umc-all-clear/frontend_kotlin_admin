package com.choi.clear_admin.ui.view

import com.choi.clear_admin.data.entity.GetReqResult

interface ReqView {
    fun onReqGetSuccess(data: GetReqResult, pos: Int)
    fun onReqGetFailure(code: String)
}