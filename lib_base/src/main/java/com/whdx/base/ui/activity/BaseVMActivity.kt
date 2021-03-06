package com.whdx.base.ui.activity

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import com.coder.zzq.smartshow.toast.SmartToast
import com.whdx.base.common.callback.EmptyCallBack
import com.whdx.base.common.callback.ErrorCallBack
import com.whdx.base.common.callback.LoadingCallBack
import com.whdx.base.vm.BaseViewModel
import com.kingja.loadsir.callback.SuccessCallback
import com.whdx.base.common.state.State
import com.whdx.base.common.state.StateType
import com.wwy.android.ui.base.BaseActivity


/**
 * @Author dinghui
 * @Date 2020/9/20 0018 16:29
 */
abstract class BaseVMActivity<VM : BaseViewModel> : BaseActivity() {
    lateinit var mViewModel: VM

    override fun initActivity(savedInstanceState: Bundle?) {
        mViewModel = initVM()
        mViewModel.loadState.observe(this, observer)
        startObserve()
        super.initActivity(savedInstanceState)
    }

    abstract fun initVM(): VM

    abstract fun startObserve()

    open fun showLoading() {
        loadService.showCallback(LoadingCallBack::class.java)
    }

    open fun showSuccess() {
        loadService.showCallback(SuccessCallback::class.java)
    }

    open fun showError(msg: String) {
        SmartToast.show(msg)
        loadService.showCallback(ErrorCallBack::class.java)
    }

    open fun showEmpty() {
        loadService.showCallback(EmptyCallBack::class.java)
    }

    /**
     * 分发应用状态
     */
    private val observer by lazy {
        Observer<State> {
            it?.let {
                when (it.code) {
                   StateType.SUCCESS -> showSuccess()
                   StateType.LOADING -> showLoading()
                   StateType.ERROR -> showError(it.message)
                   StateType.NETWORK_ERROR -> showError("网络出现问题啦")
                   StateType.EMPTY -> showEmpty()
                }
            }
        }
    }
}