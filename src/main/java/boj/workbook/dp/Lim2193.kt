package boj.workbook.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp0 = LongArray(n + 1)
    val dp1 = LongArray(n + 1)
    dp0[1] = 0
    dp1[1] = 1

    for (i in 2..n) {
        dp0[i] = dp0[i - 1] + dp1[i - 1]
        dp1[i] = dp0[i - 1]
    }

    println(dp0[n] + dp1[n])
}
