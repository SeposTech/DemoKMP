package com.harshit.demokmp.viewmodel

import androidx.lifecycle.ViewModel
import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.UserLoginResponse
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.interfaces.LoginHandler
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.StateFlow

class AndroidLoginViewModel(
    private val userLoginUseCase: UserLoginUseCase
) : ViewModel(), LoginHandler {


    private val sharedVM = LoginViewModel(userLoginUseCase)
    override val loginState: StateFlow<LoginViewModel.UiState?>
        get() = sharedVM.loginState

    override fun onCleared() {
        super.onCleared()
        sharedVM.clear()
    }

    override fun login(request: UserLoginRequest) {
        sharedVM.login(request)
    }

}