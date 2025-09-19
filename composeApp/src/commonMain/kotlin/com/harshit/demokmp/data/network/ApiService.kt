package com.harshit.demokmp.data.network

import com.harshit.demokmp.domain.models.StoreListResponse
import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.UserLoginResponse

interface ApiService {

    suspend fun userLogin(userLoginRequest: UserLoginRequest): UserLoginResponse

    suspend fun getStoreList(
        searchType: String = "2",
        sort: String = "1",
        start: String = "0",
        limit: String = "100",
        vendorType: Int = 0
    ): StoreListResponse
}