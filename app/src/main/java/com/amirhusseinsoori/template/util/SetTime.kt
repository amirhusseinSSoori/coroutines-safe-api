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

    fun setTime(num: String): String {


        val year: String = num.substring(0, 4)
        val mouth: String = num.substring(4, 6)
        val time: String = num.substring(8, 10)
        val min: String = num.substring(10, 12)
        val second: String = num.substring(12, 14)
        return "${setMouth(mouth, list)} $year ساعت $time و $min دقیقه و $second  ثانیه"

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