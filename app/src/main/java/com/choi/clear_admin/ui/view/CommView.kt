package com.choi.clear_admin.ui.view

import com.choi.clear_admin.data.entity.GetCommResult

interface CommView {
    fun onCommGetSuccess(data: GetCommResult)
    fun onCommGetFailure(code: String)
}