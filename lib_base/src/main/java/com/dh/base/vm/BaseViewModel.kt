package com.dh.base.vm

import androidx.lifecycle.*
import kotlinx.coroutines.*

/**
 * @Description
 * @Author dinghui
 * @Date 2020/9/18 0018 16:29
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {
    /**
     * 运行在UI线程的协程 viewModelScope 已经实现了在onCleared取消协程
     */
    fun launchUI(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch {
        block()
    }

}