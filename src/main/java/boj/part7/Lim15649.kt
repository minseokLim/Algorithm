package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

private val answer = StringJoiner(System.lineSeparator())

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val visited = BooleanArray(n + 1)

    for (i in 1..n) {
        solve(i, visited, 1, "$i", n, m)
        visited[i] = false
    }

    println(answer)
}

private fun solve(idx:Int, visited: BooleanArray, depth: Int, result: String, n: Int, m: Int) {
    visited[idx] = true

    if (depth == m) {
        answer.add(result)
        return
    }

    for (i in 1..n) {
        if (visited[i].not()) {
            solve(i, visited, depth + 1, "$result $i", n, m)
            visited[i] = false
        }
    }
}
