package boj.workbook.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    if (n == 1) {
        println(1)
        return
    }

    val dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 3

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007
    }
    println(dp[n] % 10007)
}
