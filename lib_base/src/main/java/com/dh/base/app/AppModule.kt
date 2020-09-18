package com.dh.base.app

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @ClassName AppModule
 * @Description
 * @Author dinghui
 * @Date 2020/9/18 0018 16:33
 */
val viewModelModule = module {
//    viewModel {  }
}

val repositoryModule = module {
    single {  }
}

val appModule = listOf(viewModelModule, repositoryModule)
