package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

private var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val sequence = br.readLine().split(" ").map { it.toInt() }

    for (i in 0 until n) {
        dfs(i, sequence, 0, n, s)
    }

    println(count)
}

private fun dfs(idx: Int, sequence: List<Int>, sum: Int, n: Int, s: Int) {
    val localSum = sum + sequence[idx]

    if (localSum == s) {
        count++
    }

    for (i in idx + 1 until n) {
        dfs(i, sequence, localSum, n, s)
    }
}
