package com.harshit.demokmp.interfaces

import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.StateFlow

interface LoginHandler {
    val loginState: StateFlow<LoginViewModel.UiState?>

    val  isConnected: StateFlow<Boolean>
    fun login(request: UserLoginRequest)
}