package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val count = Array(n + 1) { LongArray(2) }
    count[1][1] = 1

    for (i in 2..n) {
        count[i][0] = count[i - 1][0] + count[i - 1][1]
        count[i][1] = count[i - 1][0]
    }

    println(count[n].sum())
}
