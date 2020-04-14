package subtask4

import java.util.regex.Matcher
import java.util.regex.Pattern

class Pangram {

    fun getResult(inputString: String): String {
        val checkPangram = ifPangram(inputString)
        return convertPangram(inputString, checkPangram)
    }

    fun ifPangram(msg: String): Boolean {
        var char = 'a'
        val str = msg.toLowerCase()
        var checkABC = 0
        var i = 0
        while (char.toInt() < 123) {
            if (char == str.get(i)) {
                i = 0
                char = char.plus(1)
                checkABC++
            } else {
                if (i == str.length - 1) {
                    return false
                } else {
                    i++
                }
            }
        }
        return if (checkABC == 26) true
        else false
    }

    fun convertPangram(msg: String, isPangram: Boolean): String {
        var strArray = msg.split(" ").toMutableList()
        strArray =
            strArray.filterNot { it == "" || it == "\n" || it == """+""" || it == """"""" } as MutableList<String>
        val regEX: String
        if (isPangram) {
            regEX = "[aeuioy]"
        } else {
            regEX = "[qwrtpsdfghkljzxcvbnm]"
        }
        val pattern: Pattern = Pattern.compile(regEX, Pattern.CASE_INSENSITIVE)
        var matcher: Matcher
        var positionLetter: Int
        for (i in 0..strArray.size - 1) {
            matcher = pattern.matcher(strArray[i])
            var vowCount = 0
            while (matcher.find()) {
                vowCount++
                positionLetter = matcher.start()
                strArray[i] = replaceLetter(strArray[i], positionLetter)
            }
            strArray[i] = "" + vowCount + strArray[i]
        }
        strArray.sortBy { it.get(0) }

        return getString(strArray)
    }

    fun getString(arrayString: MutableList<String>): String {
        var msg = ""
        if (arrayString.size > 2) {
            for (i in 0..arrayString.size - 2) {
                msg = msg + arrayString[i] + " "
            }
            msg += arrayString[arrayString.size - 1]
        } else msg = ""
        return msg
    }

    fun replaceLetter(word: String, numberLetter: Int): String {
        val charArray = word.toCharArray().toMutableList()
        val char = word[numberLetter]
        charArray[numberLetter] = char.toUpperCase()
        var words = ""
        for (letter in charArray) {
            words = words + letter
        }
        return words
    }
}

