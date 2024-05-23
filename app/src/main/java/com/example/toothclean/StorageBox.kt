package com.example.toothclean

import java.time.LocalDate

class StorageBox() {

    var date: LocalDate = LocalDate.now()

    fun getTodaysData(): Reminders {
        return Reminders()
    }

    fun changeDay(newDate: LocalDate) {
        date = newDate
    }
}