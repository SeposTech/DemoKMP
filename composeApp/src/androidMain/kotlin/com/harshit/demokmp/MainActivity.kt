package com.harshit.demokmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.harshit.demokmp.connectivity.ConnectivityObserver
import com.harshit.demokmp.domain.models.usecase.StoreListUseCase
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import com.harshit.demokmp.utils.PlatformLoginHelper
import com.harshit.demokmp.utils.PlatformStoreListHelper
import com.harshit.demokmp.viewmodel.AndroidLoginEntryPoint
import org.koin.android.ext.android.getKoin
import org.koin.compose.getKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val platformHelper: PlatformLoginHelper = getKoin().get()
            val platformStoreListHelper: PlatformStoreListHelper = getKoin().get()
            AndroidLoginEntryPoint(platformHelper, platformStoreListHelper = platformStoreListHelper, true)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val userLoginUseCase: UserLoginUseCase = getKoin().get()
    val connectivityObserver: ConnectivityObserver = getKoin().get()
    val sharedVM: LoginViewModel = getKoin().get()
    val platformHelper =
        PlatformLoginHelper(userLoginUseCase, connectivityObserver, sharedVM)

    val storeListUseCase: StoreListUseCase = getKoin().get()
    val storeListViewModel: StoreListViewModel = getKoin().get()
    val platformStoreListHelper = PlatformStoreListHelper(storeListUseCase,storeListViewModel)
    AndroidLoginEntryPoint(platformHelper, platformStoreListHelper = platformStoreListHelper, true)
}