package com.harshit.demokmp.data.network.repository

import com.harshit.demokmp.data.network.ApiClient
import com.harshit.demokmp.data.network.ApiService
import com.harshit.demokmp.domain.models.StoreListResponse

class StoreListRepository(private val apiService: ApiService) {

    suspend fun getStoreList(): StoreListResponse{
        return apiService.getStoreList()
    }
}