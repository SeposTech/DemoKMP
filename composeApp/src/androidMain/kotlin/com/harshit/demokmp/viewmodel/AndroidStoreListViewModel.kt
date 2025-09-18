package com.harshit.demokmp.viewmodel

import androidx.lifecycle.ViewModel
import com.harshit.demokmp.interfaces.StoreListHandler
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import kotlinx.coroutines.flow.StateFlow

class AndroidStoreListViewModel(
    private val sharedVM: StoreListViewModel
): ViewModel(), StoreListHandler {


    override fun getStoreList() {
        sharedVM.getStoreList()
    }

    override var storeState: StateFlow<StoreListViewModel.UiState?>
         = sharedVM.storeState


    override fun onCleared() {
        super.onCleared()
        sharedVM.clear()
    }


}