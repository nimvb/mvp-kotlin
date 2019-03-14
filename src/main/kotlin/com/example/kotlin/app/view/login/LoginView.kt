package com.example.kotlin.app.view.login

import com.example.kotlin.app.model.Credential
import com.example.kotlin.app.view.core.console.ConsoleView

class LoginView : ConsoleView(), ILoginView {
    override fun load() {

    }

    override fun getCredentials(): Credential {
        write("[*] Username: ")
        val username = readInput()
        write("[*] Password: ")
        val password = readInput()
        return Credential(username, password)
    }
}