package com.harshit.demokmp.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class ApiClient{
    // HttpClient instance
    private val client = HttpClient {
        install(ContentNegotiation) {
            json() // JSON parsing
        }
    }

    // Suspend function for GET request
    suspend fun getUser(userId: Int): String {
        return client.get("https://jsonplaceholder.typicode.com/users/$userId").body()
    }
}