package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() }
    val (n, m) = input[0] to input[1]

    val twoCount = n.getPrimeCount(2) - m.getPrimeCount(2) - (n - m).getPrimeCount(2)
    val fiveCount = n.getPrimeCount(5) - m.getPrimeCount(5) - (n - m).getPrimeCount(5)

    println(min(twoCount, fiveCount))
}

fun Int.getPrimeCount(prime: Int): Int {
    var result = 0
    var tmp = this

    while (tmp > 1) {
        tmp /= prime
        result += tmp
    }

    return result
}
