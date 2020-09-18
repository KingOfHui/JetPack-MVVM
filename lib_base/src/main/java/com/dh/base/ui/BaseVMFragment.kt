package com.dh.base.ui

import com.dh.base.vm.BaseViewModel


/**
 * @Description
 * @Author dinghui
 * @Date 2020/9/18 0018 16:29
 */
abstract class BaseVMFragment<VM : BaseViewModel> : BaseFragment() {
    protected lateinit var mViewModel: VM

    override fun onFragmentFirstVisible() {
        mViewModel = initVM()
        startObserve()
        super.onFragmentFirstVisible()
    }


    abstract fun initVM(): VM

    abstract fun startObserve()

}