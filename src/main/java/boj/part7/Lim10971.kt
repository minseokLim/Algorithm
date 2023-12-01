package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

private var min = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val w = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = BooleanArray(n)

    for (i in 0 until n) {
        explore(i, i, w, visited, 0, 1, n)
        visited[i] = false
    }

    println(min)
}

private fun explore(start: Int, idx: Int, w: Array<IntArray>, visited: BooleanArray, fee: Int, depth: Int, n: Int) {
    visited[idx] = true
    if (depth == n) {
        if (w[idx][start] != 0 && fee + w[idx][start] < min) {
            min = fee + w[idx][start]
        }
        return
    }

    for (i in 0 until n) {
        if (!visited[i] && w[idx][i] != 0) {
            explore(start, i, w, visited, fee + w[idx][i], depth + 1, n)
            visited[i] = false
        }
    }
}
