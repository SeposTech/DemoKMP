package com.harshit.demokmp.utils

import androidx.lifecycle.ViewModel
import com.harshit.demokmp.domain.models.usecase.StoreListUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import kotlinx.coroutines.flow.StateFlow

actual class PlatformStoreListHelper actual constructor(
    val storeListUseCase: StoreListUseCase,
    val sharedVM: StoreListViewModel
): ViewModel(){
    actual fun getStoreList() {
        sharedVM.getStoreList()
    }

    actual val storeState: StateFlow<StoreListViewModel.UiState?>
        get() = sharedVM.storeState

}