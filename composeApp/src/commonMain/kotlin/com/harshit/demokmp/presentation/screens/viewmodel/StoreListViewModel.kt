package com.harshit.demokmp.presentation.screens.viewmodel

import com.harshit.demokmp.domain.models.StoreLisData
import com.harshit.demokmp.domain.models.usecase.StoreListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StoreListViewModel(
    private val storeListUseCase: StoreListUseCase
): CommonViewModel() {

    sealed interface UiState {
        object Loading: UiState
        data class Success(val data: StoreLisData?): UiState
        data class Error(val errorMsg: String?): UiState
        data class NoInternet(val lastState: Boolean): UiState
    }

    private var _uiState = MutableStateFlow<UiState>(UiState.Loading)
    var storeState: StateFlow<UiState?> = _uiState.asStateFlow()


    fun getStoreList() {
        _uiState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val result = storeListUseCase.invoke()
                _uiState.value = UiState.Success(result?.data)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message)
            }
        }


    }


}