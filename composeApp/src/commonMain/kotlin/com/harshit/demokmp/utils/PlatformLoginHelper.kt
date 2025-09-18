package com.harshit.demokmp.utils

import com.harshit.demokmp.connectivity.ConnectivityObserver
import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.StateFlow

expect class PlatformLoginHelper(
    userLoginUseCase: UserLoginUseCase,
    connectivityObserver: ConnectivityObserver,
    sharedVM: LoginViewModel
) {
    val loginState: StateFlow<LoginViewModel.UiState?>
    fun login(request: UserLoginRequest)
    fun clear()
}