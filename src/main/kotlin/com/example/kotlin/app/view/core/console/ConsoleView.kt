package com.example.kotlin.app.view.core.console

import com.example.kotlin.app.view.core.View

abstract class ConsoleView : View(), IConsoleView {

    override fun write(message: String) {
        print(message)
    }

    override fun writeLine(message: String) {
        println(message)
    }

    override fun readInput() = readLine()!!

}