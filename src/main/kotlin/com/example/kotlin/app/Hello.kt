package com.example.kotlin.app

import com.example.kotlin.app.presenter.login.ILoginPresenter
import com.example.kotlin.app.presenter.login.LoginPresenter
import com.example.kotlin.app.service.auth.AuthService
import com.example.kotlin.app.view.login.ILoginView
import com.example.kotlin.app.view.login.LoginView

fun main(args: Array<String>) {
    val view: ILoginView = LoginView()
    val presenter: ILoginPresenter = LoginPresenter(view, AuthService())
    presenter.present()
}

