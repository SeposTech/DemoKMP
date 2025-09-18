package com.harshit.demokmp

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    initKoinOnce()
    iOSLoginEntryPoint(platformLoginHelper = iOSViewModelInjector.platformLoginHelper, platformStoreListHelper = iOSViewModelInjector.platformStoreListHelper)
}
