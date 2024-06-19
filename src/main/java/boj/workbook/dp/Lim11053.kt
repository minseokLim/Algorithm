package boj.workbook.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(n)
    for (i in 0 until n) {
        dp[i] = 1
        for (j in 0 until i) {
            if (seq[i] > seq[j]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }
    println(dp.max())
}
