package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val counts = Array(n + 1) { IntArray(k + 1) }

    for (i in 1..k) {
        counts[1][i] = i
        counts[0][i] = 1
    }

    for (i in 1..n) {
        counts[i][1] = 1
    }

    for (i in 2..n) {
        for (j in 2..k) {
            counts[i][j] = (counts[i][j - 1] + counts[i - 1][j]) % 1_000_000_000
        }
    }

    println(counts[n][k])
}
