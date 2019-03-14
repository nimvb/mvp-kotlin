package com.example.kotlin.app.presenter.main

import com.example.kotlin.app.presenter.core.Presenter
import com.example.kotlin.app.view.main.IMainView

class MainPresenter(private val _view: IMainView) : Presenter<IMainView>(_view), IMainPresenter {

    override fun onLoad() {
        view.writeLine("Hello MVP!")
    }

}