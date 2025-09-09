package com.harshit.demokmp.interfaces

import com.harshit.demokmp.domain.models.UserLoginRequest

interface LoginHandler {
    fun login(request: UserLoginRequest)
}