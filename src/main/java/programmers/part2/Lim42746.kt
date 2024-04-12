package programmers.part2

class Lim42746 {
    fun solution(numbers: IntArray): String {
        return numbers.sortedWith(Comparator { a, b ->
            (b.toString() + a).toInt() - (a.toString() + b).toInt()
        }).joinToString("")
    }
}
