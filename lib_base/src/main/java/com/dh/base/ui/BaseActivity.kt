package com.wwy.android.ui.base

import android.os.Bundle
import android.util.TypedValue
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.dh.base.R
import com.gyf.immersionbar.ktx.immersionBar
import com.dh.base.ext.getAppTheme
import com.dh.base.ext.resourceId
import com.dh.base.ui.fragment.ProgressDialogFragment

/**
 * @Description
 * @Author dinghui
 * @Date 2020/9/18 0018 16:29
 */
abstract class BaseActivity : AppCompatActivity() {
    private lateinit var progressDialogFragment: ProgressDialogFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(getAppTheme())
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        initImmersionBar()
        setSmartSnackBar()
        initActivity(savedInstanceState)
    }

    open fun setSmartSnackBar() {
        SmartSnackbar.setting()
            .backgroundColorRes(
                TypedValue().resourceId(
                    R.attr.colorAccent,
                    theme
                )
            )
            .dismissOnLeave(true)
    }

    protected open fun initActivity(savedInstanceState: Bundle?) {
        initView(savedInstanceState)
        initData()
    }

    abstract fun setLayoutId(): Int
    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()
    open fun initImmersionBar() {
        immersionBar {
            statusBarColor(
                TypedValue().resourceId(
                    R.attr.colorPrimary,
                    theme
                )
            ).autoStatusBarDarkModeEnable(true, 0.2f)
        }
    }

    /**
     * 显示加载(转圈)对话框
     */
    fun showProgressDialog(@StringRes message: Int) {
        if (!this::progressDialogFragment.isInitialized) {
            progressDialogFragment = ProgressDialogFragment.newInstance()
        }
        if (!progressDialogFragment.isAdded) {
            progressDialogFragment.show(supportFragmentManager, message, false)
        }
    }

    /**
     * 隐藏加载(转圈)对话框
     */
    fun dismissProgressDialog() {
        if (this::progressDialogFragment.isInitialized && progressDialogFragment.isVisible) {
            progressDialogFragment.dismissAllowingStateLoss()
        }
    }

}