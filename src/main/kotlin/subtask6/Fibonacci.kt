package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        var nunber = 0
        var numberNext = 1
        var dataNumber: Int

        while (nunber * numberNext < n) {
            dataNumber = numberNext
            numberNext = nunber + numberNext
            nunber = dataNumber
        }
        return if (nunber * numberNext == n) {
            intArrayOf(nunber, numberNext, 1)
        } else {
            intArrayOf(nunber, numberNext, 0)
        }
    }
}