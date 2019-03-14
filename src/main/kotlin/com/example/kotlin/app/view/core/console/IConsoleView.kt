package com.example.kotlin.app.view.core.console

/**
 * Base interface for console views
 */
interface IConsoleView {
    /**
     * Print the desired [message] in the console window
     */
    fun write(message: String)

    /**
     * Print the desired [message] in a new line int the console window
     */
    fun writeLine(message: String)

    fun readInput(): String
}