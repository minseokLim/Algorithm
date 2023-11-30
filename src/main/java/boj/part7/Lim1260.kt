package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dfsAnswer = StringJoiner(" ")
private val bfsAnswer = StringJoiner(" ")

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    val connected = Array(n + 1) { BooleanArray(n + 1) }
    var visited = BooleanArray(n + 1)
    repeat(m) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        connected[i][j] = true
        connected[j][i] = true
    }

    dfs(v, connected, visited, n)

    visited = BooleanArray(n + 1)
    bfs(v, connected, visited, n)

    println(dfsAnswer)
    println(bfsAnswer)
}

private fun dfs(start: Int, connected: Array<BooleanArray>, visited: BooleanArray, n: Int) {
    visited[start] = true
    dfsAnswer.add(start.toString())

    for (i in 1..n) {
        if (!visited[i] && connected[start][i]) {
            dfs(i, connected, visited, n)
        }
    }
}

private fun bfs(start: Int, connected: Array<BooleanArray>, visited: BooleanArray, n: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.offer(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        bfsAnswer.add(polled.toString())

        for (i in 1..n) {
            if (!visited[i] && connected[polled][i]) {
                queue.offer(i)
                visited[i] = true
            }
        }
    }
}
