package programmers

import kotlin.math.ceil
import kotlin.math.floor

class Lim62048 {
    fun solution(w: Int, h: Int): Long {
        val gcd = getGcd(w, h)
        return w * h.toLong() - solve(w / gcd, h / gcd) * gcd
    }

    private fun getGcd(a: Int, b: Int): Int {
        if (a < b) {
            return getGcd(b, a)
        }

        if (a % b == 0) {
            return b
        }
        return getGcd(b, a % b)
    }

    private fun solve(a: Int, b: Int): Long {
        var result = 0L
        var start = 0.toDouble()
        for (i in 1 until  b) {
            val end = a.toDouble() / b * i
            result += getCount(start, end)
            start = end
        }
        result += getCount(start, a.toDouble())
        return result
    }

    private fun getCount(start: Double, end: Double): Long {
        return (ceil(end) - floor(start)).toLong()
    }
}
