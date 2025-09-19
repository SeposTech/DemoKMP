package com.harshit.demokmp.iosDi

import com.harshit.demokmp.connectivity.ConnectivityObserver
import com.harshit.demokmp.data.network.ApiClient
import com.harshit.demokmp.data.network.ApiService
import com.harshit.demokmp.data.network.ApiServiceImpl
import com.harshit.demokmp.data.network.repository.StoreListRepository
import com.harshit.demokmp.data.network.repository.UserRepository
import com.harshit.demokmp.domain.models.usecase.StoreListUseCase
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import com.harshit.demokmp.presentation.screens.viewmodel.StoreListViewModel
import org.koin.dsl.module

val iosModule = module{
    single { ApiClient() }

    single { get<ApiClient>().client }

    single<ApiService> { ApiServiceImpl(get()) }

    single { UserRepository(get()) }
    single { StoreListRepository(get()) }

    single { UserLoginUseCase(get()) }
    single { StoreListUseCase(get()) }

    single { ConnectivityObserver() }

    single { LoginViewModel(get(),get()) }

    single { StoreListViewModel(get()) }

}