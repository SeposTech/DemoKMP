package com.harshit.demokmp.utils

import com.harshit.demokmp.connectivity.ConnectivityObserver
import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.StateFlow

actual class PlatformLoginHelper actual constructor(
    private val userLoginUseCase: UserLoginUseCase,
    private val connectivityObserver: ConnectivityObserver,
    private val sharedVM: LoginViewModel
) {
    actual val loginState: StateFlow<LoginViewModel.UiState?>
        get() = sharedVM.loginState

    actual fun login(request: UserLoginRequest) {
        sharedVM.login(request)
    }

    actual fun clear() {
        sharedVM.clear()
    }
}