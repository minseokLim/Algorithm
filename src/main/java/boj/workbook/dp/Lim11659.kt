package boj.workbook.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val seq = br.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(n + 1)
    for (i in 1..n) {
        dp[i] = seq[i - 1] + dp[i - 1]
    }

    val answer = (1..m).map {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        dp[j] - dp[i - 1]
    }.joinToString(System.lineSeparator())

    println(answer)
}
