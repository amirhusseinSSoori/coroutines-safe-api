package com.amirhusseinsoori.template.util

import javax.inject.Inject

class SetTime @Inject constructor() {
    var list = listOf(
        "ژانویه",
        "فوریه",
        "مارس",
        "آوریل",
        "آوریل ",
        "مه",
        "ژوئن",
        "جولای",
        "اوت ",
        "سپتامبر",
        "اکتبر",
        "نوامبر",
        "دسامبر "
    )
    fun time(num: String): String {


        val year = num.substring(0, 4)
        val mouth = num.substring(4, 6)
        val day: String = num.substring(6, 8)
        val time = num.substring(8, 10)
        val min = num.substring(10, 12)
        val second = num.substring(12, 14)
        return day + " ${setMouth(mouth, list)} $year ساعت $time و $min دقیقه و $second  ثانیه"

    }

    private fun setMouth(m: String, list: List<String>): String {
        return when (m) {
            "01" -> list[0]
            "02" -> list[1]
            "03" -> list[2]
            "04" -> list[3]
            "05" -> list[4]
            "06" -> list[5]
            "07" -> list[6]
            "08" -> list[7]
            "09" -> list[8]
            "10" -> list[9]
            "11" -> list[10]
            "12" -> list[11]
            else -> ""
        }
    }
}