package com.harshit.demokmp.domain.models.usecase

import com.harshit.demokmp.data.network.repository.StoreListRepository
import com.harshit.demokmp.domain.models.StoreListResponse

class StoreListUseCase(private val storeListRepository: StoreListRepository) {

    suspend operator fun invoke(): StoreListResponse? {
       return try {
            storeListRepository.getStoreList()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}