package boj.workbook.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val scores = (1..n).map { br.readLine().toInt() }

    if (n > 2) {
        val dp = IntArray(n)
        dp[0] = scores[0]
        dp[1] = scores[0] + scores[1]
        dp[2] = maxOf(scores[0] + scores[2], scores[1] + scores[2])

        for (i in 3 until n) {
            dp[i] = maxOf(dp[i - 2] + scores[i], dp[i - 3] + scores[i - 1] + scores[i])
        }

        println(dp[n - 1])
    } else {
        println(scores.sum())
    }
}
