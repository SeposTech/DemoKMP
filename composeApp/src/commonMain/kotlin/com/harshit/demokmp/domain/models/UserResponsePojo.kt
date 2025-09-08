package com.harshit.demokmp.domain.models

data class UserRegistrationResponse(
    val data: String? = null,
) : BaseResponse()

data class UserLoginResponse(
    val data: LoginData? = null,
) : BaseResponse()

data class LoginData(
    var name: String? = null,
    var email: String? = null,
    var mobile: String? = null,
    var address: String? = null,
    var jwt_token: String? = null,
    var status: String? = null,
    var user_id: String? = null

    )
