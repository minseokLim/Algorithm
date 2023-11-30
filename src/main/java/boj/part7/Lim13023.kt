package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

private var solved = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n ,m) = br.readLine().split(" ").map { it.toInt() }
    val friends = Array(n) { mutableSetOf<Int>() }

    repeat(m) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        friends[i].add(j)
        friends[j].add(i)
    }

    val visited = BooleanArray(n)

    for (i in 0 until n) {
        if (solved) break

        dfs(i, friends, visited, n, 1)
        visited[i] = false
    }

    if (solved) {
        println(1)
    } else {
        println(0)
    }
}

private fun dfs(start: Int, friends: Array<out Set<Int>>, visited: BooleanArray, n: Int, depth: Int) {
    visited[start] = true
    if (depth == 5) {
        solved = true
        return
    }
    if (solved) return

    friends[start].forEach {
        if (visited[it].not()) {
            dfs(it, friends, visited, n, depth + 1)
            visited[it] = false
        }
    }
}
