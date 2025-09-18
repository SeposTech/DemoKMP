package com.harshit.demokmp.presentation.screens

import StoreListRow
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harshit.demokmp.domain.models.StoreListResult
import com.harshit.demokmp.interfaces.StoreListHandler
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun StoreListPage(storeListHandler: StoreListHandler) {

    val uiState = storeListHandler.storeState.collectAsState()

    when (val result = uiState.value) {
        is StoreListViewModel.UiState.Loading -> {
            LoaderPage()
        }

        is StoreListViewModel.UiState.Success -> {
            ShowStoreList(result.data?.result)
        }

        is StoreListViewModel.UiState.Error -> {}
        is StoreListViewModel.UiState.NoInternet -> {
            NoInternetPage(onRetry = {})
        }

        else -> Unit
    }

    LaunchedEffect(Unit) {
        storeListHandler.getStoreList()
    }

}

@Composable
fun ShowStoreList(result: List<StoreListResult>?) {

    Surface(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = { CommonTopBar("StoreList") }
        ) { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                result?.let {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().padding(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        items(it) { storeListResult ->
                            StoreListRow(storeListResult)

                        }
                    }

                }
            }

        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopBar(title: String) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        },
        navigationIcon = {

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }


        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Red)
    )

}

@Preview
@Composable
fun PreviewStoreListPage() {
    ShowStoreList(null)
}