package com.harshit.demokmp

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    initKoinOnce()
    iOSLoginEntryPoint(loginViewModel = iOSViewModelInjector.loginViewModel, storeListViewModel = iOSViewModelInjector.storeListViewModel)
}
