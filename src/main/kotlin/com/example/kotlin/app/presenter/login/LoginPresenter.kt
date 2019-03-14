package com.example.kotlin.app.presenter.login

import com.example.kotlin.app.presenter.core.Presenter
import com.example.kotlin.app.presenter.main.IMainPresenter
import com.example.kotlin.app.presenter.main.MainPresenter
import com.example.kotlin.app.service.auth.IAuthService
import com.example.kotlin.app.view.login.ILoginView
import com.example.kotlin.app.view.main.IMainView
import com.example.kotlin.app.view.main.MainView

class LoginPresenter(private val _view: ILoginView, val authService: IAuthService) : Presenter<ILoginView>(_view),
    ILoginPresenter {
    override fun onLoad() {
        val credential = view.getCredentials()
        if (authService.authenticate(credential)) {
            val mainView: IMainView = MainView()
            val mainPresenter: IMainPresenter = MainPresenter(mainView)
            mainPresenter.present()
        } else {
            view.writeLine("[*] Error: Invalid credential!")
        }

    }
}