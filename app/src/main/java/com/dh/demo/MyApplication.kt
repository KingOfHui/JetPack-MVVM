package com.dh.demo

import android.app.Application
import android.app.UiModeManager
import android.content.Context
import android.util.TypedValue
import com.coder.zzq.smartshow.core.SmartShow
import com.whdx.base.BuildConfig
import com.whdx.base.R
import com.whdx.base.app.BaseApplication
import com.whdx.base.util.ActivityHelper
import com.jeremyliao.liveeventbus.LiveEventBus
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.tencent.mmkv.MMKV
import com.whdx.base.ext.getNightMode
import com.whdx.base.ext.resourceId
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber
import kotlin.properties.Delegates

/**
 * @Description
 * @Author dinghui
 * @Date 2020/9/20 0018 16:27
 */
class MyApplication :BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}