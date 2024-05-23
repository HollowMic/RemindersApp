package com.example.toothclean

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateUtil(
    private var date: LocalDate = LocalDate.now(),
    private val longDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("EEEE',\n'dd'th of' MMM"),
    private val shortDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
) {


    fun nextDay() {
        date = date.plusDays(1)
    }

    fun previousDay() {
        date = date.minusDays(1)
    }

    fun shortDateString(): String {
        return date.format(shortDateFormatter)
    }

    fun longDateString(): String {
        return date.format(longDateFormatter)
    }
}