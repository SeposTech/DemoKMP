package com.harshit.demokmp.presentation.screens.viewmodel

import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.UserLoginResponse
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userLoginUseCase: UserLoginUseCase
) {
    private val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private var _loginState = MutableStateFlow<Result<UserLoginResponse?>?>(null)
    val loginState: StateFlow<Result<UserLoginResponse?>?> get() = _loginState

    fun login(userLoginRequest: UserLoginRequest){
        viewModelScope.launch {
            try {
                val result = userLoginUseCase.invoke(userLoginRequest)
                _loginState.value = Result.success(result)
            } catch (e: Exception){
                _loginState.value = Result.failure(e)
            }
        }
    }

    fun clear() {
        // cancel jobs if needed
    }


}