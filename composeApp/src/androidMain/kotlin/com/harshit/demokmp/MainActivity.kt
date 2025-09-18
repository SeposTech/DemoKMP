package com.harshit.demokmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.harshit.demokmp.connectivity.ConnectivityObserver
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import com.harshit.demokmp.utils.PlatformLoginHelper
import com.harshit.demokmp.viewmodel.AndroidLoginEntryPoint
import com.harshit.demokmp.viewmodel.AndroidStoreListViewModel
import org.koin.android.ext.android.getKoin
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.getKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val androidStoreViewmodel: AndroidStoreListViewModel = koinViewModel()
            val userLoginUseCase: UserLoginUseCase = getKoin().get()
            val connectivityObserver: ConnectivityObserver = getKoin().get()
            val sharedVM: LoginViewModel = getKoin().get()
            val platformHelper =
                PlatformLoginHelper(userLoginUseCase, connectivityObserver, sharedVM)
            AndroidLoginEntryPoint(platformHelper, androidStoreViewmodel, true)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val androidStoreViewmodel: AndroidStoreListViewModel = koinViewModel()
    val userLoginUseCase: UserLoginUseCase = getKoin().get()
    val connectivityObserver: ConnectivityObserver = getKoin().get()
    val sharedVM: LoginViewModel = getKoin().get()
    val platformHelper =
        PlatformLoginHelper(userLoginUseCase, connectivityObserver, sharedVM)
    AndroidLoginEntryPoint(platformHelper, androidStoreViewmodel, true)
}