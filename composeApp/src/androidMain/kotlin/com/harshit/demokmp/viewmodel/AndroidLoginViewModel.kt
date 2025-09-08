package com.harshit.demokmp.viewmodel

import androidx.lifecycle.ViewModel
import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel

class AndroidLoginViewModel(
    private val userLoginUseCase: UserLoginUseCase
) : ViewModel() {

    private val sharedVM = LoginViewModel(userLoginUseCase)

    fun userLogin(userLoginRequest: UserLoginRequest) {
        sharedVM.login(userLoginRequest)
    }

    override fun onCleared() {
        super.onCleared()
        sharedVM.clear()
    }

}