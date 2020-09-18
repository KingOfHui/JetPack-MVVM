package com.dh.base.app

import android.app.Application
import android.app.UiModeManager
import android.content.Context
import android.util.TypedValue
import com.coder.zzq.smartshow.core.SmartShow
import com.dh.base.BuildConfig
import com.dh.base.R
import com.dh.base.util.ActivityHelper
import com.jeremyliao.liveeventbus.LiveEventBus
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.tencent.mmkv.MMKV
import com.dh.base.ext.getNightMode
import com.dh.base.ext.resourceId
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber
import kotlin.properties.Delegates

/**
 * @Description
 * @Author dinghui
 * @Date 2020/9/18 0018 16:27
 */
class MyApplication : Application() {
    companion object {
        var CONTEXT: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
        ActivityHelper.init(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@MyApplication)
            modules(appModule)
        }
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColorsId(
                TypedValue().resourceId(R.attr.colorPrimary, context.theme),
                TypedValue().resourceId(R.attr.textColorPrimary, context.theme)
            ) //全局设置主题颜色
            ClassicsHeader(context) //.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        }
//        LoadMoreModuleConfig.defLoadMoreView = CustomLoadMoreView()
        MMKV.initialize(this)
        LiveEventBus.config()
        SmartShow.init(this)
        (getSystemService(Context.UI_MODE_SERVICE) as UiModeManager).nightMode= getNightMode()
    }
}