package com.harshit.demokmp.di

import com.harshit.demokmp.network.ApiClient
import org.koin.dsl.module

val commonModule = module {
    single { ApiClient() }
}