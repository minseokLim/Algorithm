package boj.part8

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val dp = Array(n + 1) { IntArray(k + 1) }
    for (i in 1..n) {
        val (w, v) = br.readLine().split(" ").map { it.toInt() }

        for (j in 0..k) {
            dp[i][j] = dp[i - 1][j]
            if (j >= w && j - w >= 0) {
                dp[i][j] = maxOf(dp[i][j], dp[i - 1][j - w] + v)
            }
        }
    }
    println(dp[n][k])
}
