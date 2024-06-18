package boj.workbook.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = IntArray(n + 1)
    dp[1] = 0
    val trace = IntArray(n + 1)

    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        trace[i] = i - 1

        if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
            dp[i] = dp[i / 2] + 1
            trace[i] = i / 2
        }
        if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
            dp[i] = dp[i / 3] + 1
            trace[i] = i / 3
        }
    }

    println(dp[n])

    var answer = ""
    var idx = n
    while (idx > 0) {
        answer += "$idx "
        idx = trace[idx]
    }

    println(answer)
}
