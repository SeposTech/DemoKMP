package com.harshit.demokmp

import androidx.compose.ui.window.ComposeUIViewController
import com.harshit.demokmp.utils.PlatformLoginHelper

fun MainViewController() = ComposeUIViewController {
    initKoinOnce()
    val platformLoginHelper = PlatformLoginHelper(iOSViewModelInjector.loginUseCase,iOSViewModelInjector.connectivityObserver,iOSViewModelInjector.sharedVM)
    iOSLoginEntryPoint(platformLoginHelper = platformLoginHelper, storeListViewModel = iOSViewModelInjector.storeListViewModel)
}
