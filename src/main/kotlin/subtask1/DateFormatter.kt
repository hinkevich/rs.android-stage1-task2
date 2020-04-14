package subtask1


import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        try {
            val date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            val formatter = DateTimeFormatter.ofPattern("d MMMM, EEEE")
            return date.format(formatter)
        } catch (e: DateTimeException) {
            return "Такого дня не существует"
        }
    }
}