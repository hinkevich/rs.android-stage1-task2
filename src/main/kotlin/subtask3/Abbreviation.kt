package subtask3

class Abbreviation {
    fun abbreviationFromA(a: String, b: String): String {
        val msg = a.toUpperCase()
        var i = 0
        var j = 0
        var k = 0
        while (i < b.length) {
            while (j < msg.length) {
                if (b[i] == msg[j]) {
                    j++
                    k++
                    break
                } else {
                    j++
                }
            }
            i++
        }
        print(k)
        return (if (k == b.length) {
            "YES"
        } else {
            "NO"
        })
    }
}