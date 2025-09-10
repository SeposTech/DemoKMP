package com.harshit.demokmp.presentation.screens.viewmodel

import com.harshit.demokmp.domain.models.LoginData
import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.UserLoginResponse
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.interfaces.LoginHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userLoginUseCase: UserLoginUseCase
) : LoginHandler {
    private val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private var _loginState = MutableStateFlow<UiState?>(null)
    override val loginState: StateFlow<UiState?> get() = _loginState

    sealed interface UiState {
        object Loading : UiState
        data class Success(val data: LoginData?) : UiState
        data class Error(val error: String?) : UiState
    }

    override fun login(request: UserLoginRequest) {
        _loginState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val result = userLoginUseCase.invoke(request)
                _loginState.value = UiState.Success(result?.data)
            } catch (e: Exception) {
                _loginState.value = UiState.Error(e.message)
            }
        }
    }

    fun clear() {
        // cancel jobs if needed
    }


}