package com.example.kotlin.app.service.auth

import com.example.kotlin.app.model.Credential
import com.example.kotlin.app.service.core.IService

interface IAuthService : IService {

    fun authenticate(credential: Credential): Boolean
}