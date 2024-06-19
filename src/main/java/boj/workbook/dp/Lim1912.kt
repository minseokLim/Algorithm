package boj.workbook.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(n)
    dp[0] = seq[0]
    for (i in 1 until n) {
        dp[i] = maxOf(dp[i - 1] + seq[i], seq[i])
    }

    println(dp.max())
}
