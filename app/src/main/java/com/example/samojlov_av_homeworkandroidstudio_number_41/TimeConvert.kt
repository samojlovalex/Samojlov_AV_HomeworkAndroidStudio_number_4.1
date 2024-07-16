package com.example.samojlov_av_homeworkandroidstudio_number_4

class TimeConvert {
    fun timeSecond(time: String): Int {
        val timeHours = time.substringBefore('h').toIntOrNull() ?: 0
        val timeMinute = time.substringAfter('h').substringBefore('m').toIntOrNull() ?: 0
        val timeSecond = time.substringAfter('m').substringBefore('s').toIntOrNull() ?: 0

        val timeSecondOut = timeHours * 3600 + timeMinute * 60 + timeSecond.toInt()
        return timeSecondOut
    }

    fun timeStructure(second: Int): String {
        val timeHoursOut = when (val timeHours = second / 3600) {
            0 -> ""
            else -> timeHours.toString() + "h"
        }

        val timeMinuteOut = when (val timeMinute =
            (second - (second - (second % 3600))) / 60) {
            0 -> ""
            else -> timeMinute.toString() + "m"
        }

        val timeSecondOut = when (val timeSecond =
            (second - (second - (second % 3600))) % 60) {
            0 -> ""
            else -> timeSecond.toString() + "s"
        }
        return (timeHoursOut + timeMinuteOut + timeSecondOut).trim()
    }
}