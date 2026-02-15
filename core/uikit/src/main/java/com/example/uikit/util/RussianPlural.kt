package com.example.uikit.util

internal object RussianPlural {
    fun formatDays(days: Int): String {
        val lastTwoDigits = days % 100
        val lastDigit = days % 10

        return when {
            lastTwoDigits in 11..14 -> "$days дней"
            lastDigit == 1 -> "$days день"
            lastDigit in 2..4 -> "$days дня"
            else -> "$days дней"
        }
    }
    fun formatHours(hours: Int): String {
        val lastTwoDigits = hours % 100
        val lastDigit = hours % 10

        return when {
            lastTwoDigits in 11..14 -> "$hours часов"
            lastDigit == 1 -> "$hours час"
            lastDigit in 2..4 -> "$hours часа"
            else -> "$hours часов"
        }
    }

    fun formatDotsText(count: Int): String {
        val lastTwoDigits = count % 100
        val lastDigit = count % 10

        val word = when {
            lastTwoDigits in 11..14 -> "точек"
            lastDigit == 1 -> "точка"
            lastDigit in 2..4 -> "точки"
            else -> "точек"
        }

        return "$count $word"
    }
}