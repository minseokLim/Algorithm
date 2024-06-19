package boj.workbook.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val triangle = (1..n).map { br.readLine().split(" ").map { it.toInt() } }

    val dp = Array(n) { IntArray(n) }
    dp[0][0] = triangle[0][0]

    for (i in 1 until n) {
        triangle[i].forEachIndexed { idx, elem ->
            if (idx - 1 >= 0) {
                dp[i][idx] = dp[i - 1][idx - 1] + elem
            }
            if (idx < triangle[i - 1].size) {
                dp[i][idx] = maxOf(dp[i][idx], dp[i - 1][idx] + elem)
            }
        }
    }
    println(dp[n - 1].max())
}
