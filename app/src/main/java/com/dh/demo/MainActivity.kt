package com.dh.demo

import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.coder.zzq.smartshow.toast.SmartToast
import com.whdx.base.ui.activity.BaseBindingActivity
import com.dh.demo.databinding.ActivityMainBinding
import com.whdx.data.respository.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.getViewModel


class MainActivity : BaseBindingActivity<UserViewModel, ActivityMainBinding>() {
    override fun initVM(): UserViewModel = getViewModel()


    override fun setLayoutId() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        mDataBinding.tvHello2.setOnClickListener {
            mViewModel.login("9241885", "111111")
        }
    }

    override fun initData() {

    }

    override fun startObserve() {
        mViewModel.run {
            mUser.observe(this@MainActivity, Observer {
                SmartToast.complete(mUser.value?.username)
            })
        }
    }


}