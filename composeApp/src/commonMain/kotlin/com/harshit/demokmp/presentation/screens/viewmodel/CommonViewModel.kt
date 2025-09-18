package com.harshit.demokmp.presentation.screens.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open  class CommonViewModel  {
    private val job = SupervisorJob()
    protected val viewModelScope = CoroutineScope(Dispatchers.Main + job)


    fun clear() {
        job.cancel()
    }
}