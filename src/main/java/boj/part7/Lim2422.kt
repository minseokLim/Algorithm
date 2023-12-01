package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

private var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val bad = Array(n + 1) { BooleanArray(n + 1) }
    repeat(m) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        bad[i][j] = true
        bad[j][i] = true
    }
    val visited = BooleanArray(n + 1)

    for (i in 1..n) {
        search(i, bad, visited, 1, n)
        visited[i] = false
    }

    println(count)
}

private fun search(idx: Int, bad: Array<BooleanArray>, visited: BooleanArray, depth: Int, n: Int) {
    visited[idx] = true

    if (depth == 3) {
        count++
        return
    }

    for (i in idx + 1..n) {
        if (isAllGood(i, bad, visited, n)) {
            search(i, bad, visited, depth + 1, n)
            visited[i] = false
        }
    }
}

private fun isAllGood(idx: Int, bad: Array<BooleanArray>, visited: BooleanArray, n: Int): Boolean {
    for (i in 1..n) {
        if (visited[i] && bad[idx][i]) {
            return false
        }
    }
    return true
}
