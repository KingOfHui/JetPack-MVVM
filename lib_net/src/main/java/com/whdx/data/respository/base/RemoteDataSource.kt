package com.whdx.data.respository.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.dh.base.app.MyApplication
import com.whdx.data.data.base.ResultData
import com.whdx.data.data.user.User
import com.wwy.android.data.api.RetrofitClient

/**
 * @Description
 * @Author dinghui
 * @Date 2020/9/18 0018 17:27
 */
class RemoteDataSource {
    suspend fun login(username: String, password: String) =
        safeApiCall(
            call = { requestLogin(username, password) }
        )
    private suspend fun requestLogin(username: String, password: String): ResultData<User> {
        val login = RetrofitClient().service.login(username, password)
        if (login.code == 0) {
            return ResultData.Success(login.data)
        }
        return ResultData.ErrorMessage(login.msg)
    }
}
