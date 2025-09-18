package com.harshit.demokmp.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.harshit.demokmp.interfaces.StoreListHandler
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun StoreListPage(storeListHandler: StoreListHandler) {

    val uiState = storeListHandler.storeState.collectAsState()

    when(uiState.value) {
        is StoreListViewModel.UiState.Loading-> {LoaderPage()}
        is StoreListViewModel.UiState.Success -> {ShowStoreList()}
        is StoreListViewModel.UiState.Error -> {}
        is StoreListViewModel.UiState.NoInternet -> {NoInternetPage(onRetry = {})}
        else -> Unit
    }

    LaunchedEffect(Unit) {
        storeListHandler.getStoreList()
    }

}

@Composable
fun ShowStoreList() {

    Surface(modifier = Modifier.fillMaxSize()) {





    }
}

@Preview
@Composable
fun PreviewStoreListPage() {
    ShowStoreList()
}