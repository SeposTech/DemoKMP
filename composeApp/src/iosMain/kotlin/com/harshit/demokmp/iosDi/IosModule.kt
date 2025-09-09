package com.harshit.demokmp.iosDi

import com.harshit.demokmp.data.network.ApiClient
import com.harshit.demokmp.data.network.repository.UserRepository
import com.harshit.demokmp.domain.models.usecase.UserLoginUseCase
import com.harshit.demokmp.presentation.screens.viewmodel.LoginViewModel
import org.koin.dsl.module

val iosModule = module{
    single { ApiClient() }

    single { UserRepository(get()) }

    single { UserLoginUseCase(get()) }

    single { LoginViewModel(get()) }

}