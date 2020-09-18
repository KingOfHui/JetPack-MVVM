package com.dh.base.ext

import android.app.Application
import com.dh.base.app.MyApplication
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor

/**
 * @Description
 * @Author dinghui
 * @Date 2020/9/18 0018 16:22
 */
object CookieClass {
    /**Cookie*/
    val cookiePersistor = SharedPrefsCookiePersistor(MyApplication.CONTEXT)
    val cookieJar = PersistentCookieJar(SetCookieCache(), cookiePersistor)
    /**清除Cookie*/
    fun clearCookie() = cookieJar.clear()

    /**是否有Cookie*/
    fun hasCookie() = cookiePersistor.loadAll().isNotEmpty()
}