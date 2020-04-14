package subtask5


import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        return when (blockB) {
            LocalDate::class -> operationLocalDate(blockA)
            String::class -> operationString(blockA)
            Int::class -> operationInt(blockA)

            else -> "ups"
        }
    }

    fun operationLocalDate(array: Array<Any>): Any {
        val arrayDate = mutableListOf<Long>()
        for (element in array) {
            if (element is LocalDate) {
                arrayDate.add(element.toEpochDay())
            }
        }
        arrayDate.sort()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY")
        return LocalDate.ofEpochDay(arrayDate.last() - 365).format(formatter)
    }
    fun operationString(array: Array<Any>): Any {
        var msg = ""
        for (element in array)
            if (element is String) {
                msg = msg + element
            }
        return msg
    }
    fun operationInt(array: Array<Any>): Any {
        var summa = 0
        for (element in array)
            if (element is Int) {
                summa = summa + element
            }

        return summa
    }
}
