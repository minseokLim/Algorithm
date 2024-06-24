package boj.workbook.dp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(n)
    dp[0] = 1

    val partSeq = Array(n) { mutableListOf<Int>() }
    partSeq[0].add(seq[0])

    for (i in 1 until n) {
        dp[i] = 1
        partSeq[i].add(seq[i])
        var temp = -1

        for (j in 0 until i) {
            if (seq[i] > seq[j] && dp[j] + 1 > dp[i]) {
                dp[i] = dp[j] + 1
                temp = j
            }
        }

        if (temp != -1) {
            partSeq[i].addAll(partSeq[temp])
        }
    }

    val answer = dp.max()
    println(answer)
    println(partSeq[dp.indexOf(answer)].reversed().joinToString(" "))
}
