package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }
    val maxes = IntArray(n) { 1 }

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (seq[j] < seq[i] && maxes[j] + 1 > maxes[i]) {
                maxes[i] = maxes[j] + 1
            }
        }
    }

    println(maxes.max())
}
