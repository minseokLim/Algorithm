package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val dp = IntArray(11)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    dp[4] = 7

    for (i in 5..10) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }

    val answer = StringJoiner(System.lineSeparator())
    repeat(t) {
        answer.add(dp[br.readLine().toInt()].toString())
    }

    println(answer)
}
