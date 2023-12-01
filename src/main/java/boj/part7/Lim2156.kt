package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val wines = IntArray(10_000)
    repeat(n) {
        wines[it] = br.readLine().toInt()
    }

    val maxes = IntArray(10_000)
    maxes[0] = wines[0]
    maxes[1] = wines[1] + wines[0]
    maxes[2] = maxOf(maxes[1], wines[2] + wines[0], wines[2] + wines[1])

    for (i in 3 until n) {
        maxes[i] = maxOf(maxes[i - 1], wines[i] + maxes[i - 2], wines[i] + wines[i - 1] + maxes[i - 3])
    }

    println(maxes[n - 1])
}
