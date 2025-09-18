package com.harshit.demokmp

import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object iOSViewModelInjector: KoinComponent {
    val loginViewModel: LoginViewModel by lazy { get() }

    val storeListViewModel: StoreListViewModel by lazy { get() }
}