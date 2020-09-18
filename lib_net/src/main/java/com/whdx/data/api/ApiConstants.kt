package com.wwy.android.data.api

/**
 * @Description
 * @Author dinghui
 * @Date 2020/9/18 0018 16:29
 */
const val WHDX_TEACHER = 1
const val teacherUrl = "https://www.baidu.com"
const val WHDX_STUDENT = 2
const val studentUrl = "https://www.baidu.io"

fun getHost(hostType: Int): String {
    lateinit var host: String
    when (hostType) {
        WHDX_TEACHER -> host = teacherUrl
        WHDX_STUDENT -> host = studentUrl
    }
    return host
}
