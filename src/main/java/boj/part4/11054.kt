package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }
    val maxes = IntArray(n)
    val revMaxes = IntArray(n)
    maxes[0] = 1
    revMaxes[n - 1] = 1

    for (i in 1 until n) {
        var max = 0

        for (j in (i - 1) downTo 0) {
            if (seq[j] < seq[i] && max < maxes[j]) {
                max = maxes[j]
            }
        }

        maxes[i] = 1 + max
    }

    for (i in (n - 2) downTo 0) {
        var max = 0

        for (j in (i + 1) until n) {
            if (seq[j] < seq[i] && max < revMaxes[j]) {
                max = revMaxes[j]
            }
        }

        revMaxes[i] = 1 + max
    }

    var answer = 0

    for (i in 0 until n) {
        answer = max(answer, maxes[i] + revMaxes[i] - 1)
    }

    println(answer)
}
