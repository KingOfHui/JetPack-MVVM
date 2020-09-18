package com.wwy.android.data.api

import com.dh.base.ext.CookieClass.cookieJar
import okhttp3.OkHttpClient

/**
 * @Description
 * @Author dinghui
 * @Date 2020/9/18 0018 16:29
 */
class RetrofitClient(hostType: Int = WHDX_TEACHER) : BaseRetrofitClient() {
    val service by lazy { getService(ApiService::class.java, hostType) }

    //okhttp 扩展
    override fun handleBuilder(builder: OkHttpClient.Builder) {
        builder.cookieJar(cookieJar)
    }
}