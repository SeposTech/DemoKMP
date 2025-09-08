package com.harshit.demokmp.data.network.repository

import com.harshit.demokmp.data.network.ApiClient
import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.UserLoginResponse

class UserRepository(val apiClient: ApiClient) {

    suspend fun userLogin(userLoginRequest: UserLoginRequest): UserLoginResponse{
        return apiClient.userLogin(userLoginRequest)
    }
}