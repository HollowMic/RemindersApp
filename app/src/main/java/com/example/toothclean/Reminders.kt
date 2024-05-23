package com.example.toothclean

class Reminders() {
    private val map: HashMap<String, Boolean> = hashMapOf()

    fun setValue(key: String, value: Boolean = false) {
        map[key] = value
    }

    fun toggleValue(key: String) {
        if (map[key] != null) {
            map[key] = !map[key]!!
        } else {
            map[key] = false
        }
    }

    fun getValue(key: String): Boolean {
        return if (map[key] != null) {
            map[key]!!
        } else {
            map[key] = false
            false
        }
    }
}
