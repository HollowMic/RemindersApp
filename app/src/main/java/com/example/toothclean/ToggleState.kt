package com.example.toothclean

class ToggleState(var state: Boolean = false, var stateChangeFun: () -> Unit) {
    fun toggle() {
        state = !state
        stateChangeFun()
    }
}