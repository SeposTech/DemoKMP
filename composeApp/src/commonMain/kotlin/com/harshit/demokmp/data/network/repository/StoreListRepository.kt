package com.harshit.demokmp.data.network.repository

import com.harshit.demokmp.data.network.ApiClient
import com.harshit.demokmp.domain.models.StoreListResponse

class StoreListRepository(private val apiClient: ApiClient) {

    suspend fun getStoreList(): StoreListResponse{
        return apiClient.getStoreList()
    }
}