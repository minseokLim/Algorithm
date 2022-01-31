package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    fun getPrimeInfoArray(n: Int): Array<Boolean> {
        val isPrime = Array(n + 1) {true}
        isPrime[0] = false
        isPrime[1] = false

        for (i in 2..(sqrt(n.toDouble()).toInt())) {
            if (!isPrime[i]) continue

            for (j in (2 * i)..n step i) {
                isPrime[j] = false
            }
        }

        return isPrime
    }

    val isPrime = getPrimeInfoArray(100_0000)
    val answer = StringBuilder()

    while (true) {
        val input = br.readLine().toInt()
        if (input == 0) break
        var result = "Goldbach's conjecture is wrong."

        for (i in 3..(input / 2)) {
            if (isPrime[i] && isPrime[input - i]) {
                result = "$input = $i + ${input - i}\n"
                break
            }
        }

        answer.append(result)
    }

    println(answer)
}
