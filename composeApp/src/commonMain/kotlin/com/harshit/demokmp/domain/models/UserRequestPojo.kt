package com.harshit.demokmp.domain.models

data class UserRegistrationRequest(
    var name: String? = null,
    var email: String? = null,
    var mobile: String? = null,
    var password: String? = null,
    var confirmPassword: String? = null
)

data class UserLoginRequest(
    var email: String? = null,
    var password: String? = null,
)

data class ResetPasswordRequest(
    var email: String? = null,
    var otp: String? = null,
    var password: String? = null
)
