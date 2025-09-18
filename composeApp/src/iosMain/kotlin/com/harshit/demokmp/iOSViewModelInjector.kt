package com.harshit.demokmp

import com.harshit.demokmp.connectivity.ConnectivityObserver
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object iOSViewModelInjector: KoinComponent {

    val loginUseCase: UserLoginUseCase by lazy { get() }
    val connectivityObserver: ConnectivityObserver by lazy { get() }
    val sharedVM: LoginViewModel by lazy { get() }


    val storeListViewModel: StoreListViewModel by lazy { get() }
}