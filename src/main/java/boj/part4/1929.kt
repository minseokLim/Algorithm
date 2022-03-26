package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ")
    val m = input[0].toInt()
    val n = input[1].toInt()

    fun getPrimeInfoArray(n: Int): Array<Boolean> {
        val max = sqrt(n.toDouble()).toInt()
        val isPrime = Array(n + 1) { true }
        isPrime[0] = false
        isPrime[1] = false

        for (i in 2..max) {
            if (!isPrime[i]) continue

            for (j in (i * 2)..n step i) {
                isPrime[j] = false
            }
        }

        return isPrime
    }

    val answer = StringBuilder()
    val isPrime = getPrimeInfoArray(n)

    for (i in m..n) {
        if (isPrime[i]) {
            answer.append("$i\n")
        }
    }

    println(answer)
}
