package com.harshit.demokmp.data.network

import com.harshit.demokmp.data.network.ApiConstants.URL_STORE_LIST
import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.UserLoginResponse
import com.harshit.demokmp.data.network.ApiConstants.UR_LOGIN
import com.harshit.demokmp.domain.models.StoreListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json

class ApiClient {
    // HttpClient instance
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true // unknown keys ko ignore kare
                }
            ) // JSON parsing
        }

        // Logging plugin
        install(Logging) {
            level = LogLevel.BODY // BODY, HEADERS, INFO, ALL
            logger = object : Logger{
                override fun log(message: String) {
                    println("Ktor-Log: $message")
                }

            }// Android Studio console me log
        }
    }

    suspend fun userLogin(userLoginRequest: UserLoginRequest): UserLoginResponse {
        return client.post(UR_LOGIN) {
            contentType(ContentType.Application.Json)
            setBody(userLoginRequest)
        }.body()
    }

    suspend fun getStoreList(
        searchType: String = "2",
        sort: String = "1",
        start: String = "0",
        limit: String = "100",
        vendorType: Int = 0
    ): StoreListResponse {
     return client.get(URL_STORE_LIST) {
         contentType(ContentType.Application.Json)
         parameter("searchType", searchType)
         parameter("sort", sort)
         parameter("start", start)
         parameter("limit", limit)
         parameter("vendor_type", vendorType)
     }.body()
    }

}