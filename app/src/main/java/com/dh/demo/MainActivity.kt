package com.dh.demo

import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_hello.setOnClickListener {

            // 255,78,132
            // 255,200,103   255,85,141
            val animator = ValueAnimator.ofInt(0, 10)
            animator.duration = 1000
            animator.addUpdateListener { animation ->
                val animatedValue = animation.animatedValue as Int
                val colorStart = Color.rgb(255, 78 + animatedValue * 10, 132 - animatedValue * 3)
                val colorEnd = Color.rgb(255, 78 + animatedValue, 132 + animatedValue)
                val colors = intArrayOf(colorStart, colorEnd)
                val drawable = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors)
                drawable.cornerRadius = 25f
                drawable.gradientType = GradientDrawable.LINEAR_GRADIENT
                tv_hello.setBackground(drawable)
            }
            animator.start()
        }
    }
}