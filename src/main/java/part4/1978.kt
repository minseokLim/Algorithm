package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()

    fun getPrimeInfoArray(n: Int): Array<Boolean> {
        val max = sqrt(n.toDouble()).toInt()
        val isPrime = Array(n + 1) { true }
        isPrime[0] = false
        isPrime[1] = false

        for (i in 2..max) {
            if (!isPrime[i]) continue

            for (j in (2 * i)..n step i) {
                isPrime[j] = false
            }
        }

        return isPrime
    }

    val isPrime = getPrimeInfoArray(1000)
    println(br.readLine().split(" ").map { it.toInt() }.filter { isPrime[it] }.size)
}
