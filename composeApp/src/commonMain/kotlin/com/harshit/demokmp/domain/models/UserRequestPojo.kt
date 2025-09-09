package com.harshit.demokmp.domain.models

import kotlinx.serialization.Serializable

data class UserRegistrationRequest(
    var name: String? = null,
    var email: String? = null,
    var mobile: String? = null,
    var password: String? = null,
    var confirmPassword: String? = null
)
@Serializable
data class UserLoginRequest(
    var email: String? = null,
    var password: String? = null,
)

data class ResetPasswordRequest(
    var email: String? = null,
    var otp: String? = null,
    var password: String? = null
)
