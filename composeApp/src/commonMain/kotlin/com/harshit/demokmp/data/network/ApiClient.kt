package com.harshit.demokmp.data.network

import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.UserLoginResponse
import com.harshit.demokmp.data.network.ApiConstants.UR_LOGIN
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json

class ApiClient {
    // HttpClient instance
    private val client = HttpClient {
        install(ContentNegotiation) {
            json() // JSON parsing
        }
    }

    suspend fun userLogin(userLoginRequest: UserLoginRequest): UserLoginResponse {
        return client.post(UR_LOGIN) {
            contentType(ContentType.Application.Json)
            setBody(userLoginRequest)
        }.body()
    }
}