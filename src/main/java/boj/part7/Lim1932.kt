package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val triangle = Array(n) { IntArray(n) }
    repeat(n) {
        br.readLine().split(" ").map { it.toInt() }
            .forEachIndexed { idx, value -> triangle[it][idx] = value }
    }

    val maxes = Array(n) { IntArray(n) }
    maxes[0][0] = triangle[0][0]

    for (i in 1 until n) {
        for (j in 0..i) {
            var max = triangle[i][j] + maxes[i - 1][j]

            if (j - 1 >= 0 && triangle[i][j] + maxes[i - 1][j - 1] > max) {
                max = triangle[i][j] + maxes[i - 1][j - 1]
            }

            maxes[i][j] = max
        }
    }

    println(maxes[n - 1].max())
}
