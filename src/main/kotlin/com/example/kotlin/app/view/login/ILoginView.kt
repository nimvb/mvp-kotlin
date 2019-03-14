package com.example.kotlin.app.view.login

import com.example.kotlin.app.model.Credential
import com.example.kotlin.app.view.core.IView
import com.example.kotlin.app.view.core.console.IConsoleView

interface ILoginView : IView, IConsoleView {

    fun getCredentials(): Credential
}