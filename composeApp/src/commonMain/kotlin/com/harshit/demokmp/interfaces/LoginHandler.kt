package com.harshit.demokmp.interfaces

import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.StateFlow

interface LoginHandler {
    val loginState: StateFlow<LoginViewModel.UiState?>
    fun login(request: UserLoginRequest)
}