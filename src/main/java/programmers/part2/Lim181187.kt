package programmers.part2

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

class Lim181187 {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0
        for (i in 1..r2) {
            val min = ceil(sqrt(r1.pow(2) - i.pow(2).toDouble())).toLong()
            val max = floor(sqrt(r2.pow(2) - i.pow(2).toDouble())).toLong()

            answer += (max - min) + 1
        }

        return answer * 4
    }

    private fun Int.pow(n: Int): Long {
        var result = 1L
        repeat(n) {
            result *= this
        }
        return result
    }
}
