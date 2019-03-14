package com.example.kotlin.app.service.auth

import com.example.kotlin.app.model.Credential
import org.junit.Assert.assertEquals
import org.junit.Test

class AuthServiceTest {

    @Test
    fun authenticate() {

        val authService: IAuthService = AuthService()
        assertEquals(false, authService.authenticate(Credential("hello", "123456")))
        assertEquals(true, authService.authenticate(Credential("admin", "123456")))

    }
}