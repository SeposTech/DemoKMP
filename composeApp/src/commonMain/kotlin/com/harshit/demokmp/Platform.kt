package com.harshit.demokmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform