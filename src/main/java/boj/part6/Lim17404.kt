package boj.part6

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val price = Array(n) { IntArray(3) }
    val dp = Array(n) { IntArray(3) }
    var answer = Int.MAX_VALUE

    repeat(n) { idx ->
        price[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (i == j) {
                dp[0][j] = price[0][j]
            } else {
                dp[0][j] = 1001
            }
        }

        for (j in 1 until n) {
            dp[j][0] = price[j][0] + min(dp[j - 1][1], dp[j - 1][2])
            dp[j][1] = price[j][1] + min(dp[j - 1][0], dp[j - 1][2])
            dp[j][2] = price[j][2] + min(dp[j - 1][0], dp[j - 1][1])
        }

        for (j in 0 until 3) {
            if (i != j && dp[n - 1][j] < answer) {
                answer = dp[n - 1][j]
            }
        }
    }

    println(answer)
}
