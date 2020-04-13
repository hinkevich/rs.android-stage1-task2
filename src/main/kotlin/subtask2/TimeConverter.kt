package subtask2

class TimeConverter {


    fun toTextFormat(hour: String, minute: String): String {
        val time = arrayListOf<String>(
            "zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
            "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
            "twenty six", "twenty seven", "twenty eight", "twenty nine"
        )
        return when (minute.toInt()) {
            0 -> "${time[hour.toInt()]} o' clock"
            1 -> "one minute past ${time[hour.toInt()]}"
            in 2..14 -> "${time[minute.toInt()]} minutes past ${time[hour.toInt()]}"
            15 -> "quarter past ${time[hour.toInt()]}"
            in 16..29 -> "${time[minute.toInt()]} minutes past ${time[hour.toInt()]}"
            30 -> "half past ${time[hour.toInt()]}"
            in 30..44 -> "${time[60 - minute.toInt()]} minutes to ${time[hour.toInt() + 1]}"
            45 -> "quarter to ${time[hour.toInt() + 1]}"
            in 46..59 -> "${time[60 - minute.toInt()]} minutes to ${time[hour.toInt() + 1]}"
            60 -> "${time[hour.toInt() + 1]} o' clock"
            else -> ""
        }

    }
}
