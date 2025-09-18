package com.harshit.demokmp.domain.models

import kotlinx.serialization.Serializable

@Serializable
open class BaseResponse(
    val status: Int = 0,
    val message: String? = null,
)
