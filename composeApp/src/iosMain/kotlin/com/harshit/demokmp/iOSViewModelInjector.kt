package com.harshit.demokmp

import com.harshit.demokmp.connectivity.ConnectivityObserver
import com.harshit.demokmp.domain.models.usecase.StoreListUseCase
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import com.harshit.demokmp.utils.PlatformLoginHelper
import com.harshit.demokmp.utils.PlatformStoreListHelper
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object iOSViewModelInjector: KoinComponent {

    val loginUseCase: UserLoginUseCase by lazy { get() }
    val connectivityObserver: ConnectivityObserver by lazy { get() }
    val sharedVM: LoginViewModel by lazy { get() }

    val storeListUseCase: StoreListUseCase by lazy { get() }

    val storeListViewModel: StoreListViewModel by lazy { get() }

    val platformLoginHelper: PlatformLoginHelper by lazy { PlatformLoginHelper(loginUseCase,connectivityObserver,sharedVM) }
    val platformStoreListHelper: PlatformStoreListHelper by lazy { PlatformStoreListHelper(storeListUseCase = storeListUseCase, sharedVM = storeListViewModel) }
}