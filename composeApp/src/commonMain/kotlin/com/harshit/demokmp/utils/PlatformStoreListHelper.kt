package com.harshit.demokmp.utils

import com.harshit.demokmp.domain.models.usecase.StoreListUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import kotlinx.coroutines.flow.StateFlow

expect class PlatformStoreListHelper(
    storeListUseCase: StoreListUseCase,
    sharedVM: StoreListViewModel
) {

    fun getStoreList()

    val storeState: StateFlow<StoreListViewModel.UiState?>
}