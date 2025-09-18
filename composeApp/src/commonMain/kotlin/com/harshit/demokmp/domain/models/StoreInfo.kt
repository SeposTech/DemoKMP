package com.harshit.demokmp.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class StoreInfoResponse(
    val data: Data? = null
) : BaseResponse()

@Serializable
data class Data(
    val basicDetail: BasicDetail? = null
)
@Serializable
data class BasicDetail(
    val name: String? = null,
    val email: String? = null,
    val mobile: String? = null
)

@Serializable
data class StoreListResponse(
    val data: StoreLisData? = null
) : BaseResponse()

@Serializable
data class StoreLisData(
    val totalRecord: Int = 0,
    val result: List<StoreListResult>? = null
)
@Serializable
data class StoreListResult(
    val vendor_name: String? = null,
    val vendor_phone: String? = null,
    val vendor_address: String? = null,
    val logo: String? = null,
    val vendor_id: String? = null
)

