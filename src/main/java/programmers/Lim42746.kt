package programmers

class Lim42746 {
    fun solution(numbers: IntArray): String {
        val sortedNumbers = numbers.sortedWith { a, b ->
            (b.toString() + a.toString()).toInt() - (a.toString() + b.toString()).toInt()
        }

        if (sortedNumbers[0] == 0) {
            return "0"
        }

        return sortedNumbers.joinToString("")
    }
}
