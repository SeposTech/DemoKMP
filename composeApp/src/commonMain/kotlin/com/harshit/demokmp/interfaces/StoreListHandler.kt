package com.harshit.demokmp.interfaces

import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import kotlinx.coroutines.flow.StateFlow

interface StoreListHandler {

    fun getStoreList()

    var storeState: StateFlow<StoreListViewModel.UiState?>
}