package com.harshit.demokmp.domain.models.usecase

import com.harshit.demokmp.data.network.repository.UserRepository
import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.UserLoginResponse

class UserLoginUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(userLoginRequest: UserLoginRequest): UserLoginResponse? {
        return try {
            userRepository.userLogin(userLoginRequest)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}