package boj.workbook.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = Array(10) { IntArray(101) }
    for (i in 1..9) {
        dp[i][1] = 1
    }

    for (i in 2..n) {
        dp[0][i] = dp[1][i - 1]
        for (j in 1..8) {
            dp[j][i] = (dp[j - 1][i - 1] + dp[j + 1][i - 1]) % 1_000_000_000
        }
        dp[9][i] = dp[8][i - 1]
    }

    var answer = 0
    for (i in 0..9) {
        answer = (answer + dp[i][n]) % 1_000_000_000
    }
    println(answer)
}
