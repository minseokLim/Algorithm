package boj.workbook.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    val dp = LongArray(101)
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    dp[4] = 2
    dp[5] = 2
    for (i in 6..100) {
        dp[i] = dp[i - 1] + dp[i - 5]
    }

    val answer = (1..T).joinToString(System.lineSeparator()) { dp[br.readLine().toInt()].toString() }
    println(answer)
}
