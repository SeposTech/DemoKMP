package com.harshit.demokmp.androidDi

import com.harshit.demokmp.connectivity.ConnectivityObserver
import com.harshit.demokmp.data.network.ApiClient
import com.harshit.demokmp.data.network.repository.UserRepository
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import com.harshit.demokmp.viewmodel.AndroidLoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    single { ApiClient() }

    single { UserRepository(get()) }

    single { UserLoginUseCase(get()) }

    single { LoginViewModel(get(),get()) }

    single { ConnectivityObserver(get()) }

    viewModel { AndroidLoginViewModel(get(),get()) }
}