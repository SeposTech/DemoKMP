package com.harshit.demokmp.data.network

import com.harshit.demokmp.data.network.ApiConstants.URL_STORE_LIST
import com.harshit.demokmp.data.network.ApiConstants.UR_LOGIN
import com.harshit.demokmp.domain.models.StoreListResponse
import com.harshit.demokmp.domain.models.UserLoginRequest
import com.harshit.demokmp.domain.models.UserLoginResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ApiServiceImpl(private val client: HttpClient) : ApiService {
    override suspend fun userLogin(userLoginRequest: UserLoginRequest): UserLoginResponse {
        return client.post(UR_LOGIN) {
            contentType(ContentType.Application.Json)
            setBody(userLoginRequest)
        }.body()
    }

    override suspend fun getStoreList(
        searchType: String,
        sort: String,
        start: String,
        limit: String,
        vendorType: Int
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