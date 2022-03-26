package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }
    val maxes = IntArray(n)
    maxes[0] = 1

    for (i in 1 until n) {
        var max = 0

        for (j in (i - 1) downTo 0) {
            if (seq[j] > seq[i] && max < maxes[j]) {
                max = maxes[j]
            }
        }

        maxes[i] = 1 + max
    }

    println(maxes.maxOrNull()!!)
}
