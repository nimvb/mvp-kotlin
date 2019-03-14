package com.example.kotlin.app.service.auth

import com.example.kotlin.app.model.Credential

class AuthService : IAuthService {
    override fun authenticate(credential: Credential): Boolean {
        if (credential.username == "admin" &&
            credential.password == "123456"
        )
            return true
        return false
    }

}