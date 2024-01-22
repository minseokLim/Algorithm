package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val (r1, c1, r2, c2) = br.readLine().split(" ").map { it.toInt() }
    val visited = Array(n) { BooleanArray(n) }

    class Knight(
        val i: Int,
        val j: Int,
        val times: Int
    ) {
        fun getNexts(): List<Knight> {
            val result = mutableListOf<Knight>()

            if (i - 2 >= 0 && j - 1 >= 0 && visited[i - 2][j - 1].not()) {
                result.add(Knight(i - 2, j - 1, times + 1))
                visited[i - 2][j - 1] = true
            }
            if (i - 2 >= 0 && j + 1 < n && visited[i - 2][j + 1].not()) {
                result.add(Knight(i - 2, j + 1, times + 1))
                visited[i - 2][j + 1] = true
            }
            if (j - 2 >= 0 && visited[i][j - 2].not()) {
                result.add(Knight(i, j - 2, times + 1))
                visited[i][j - 2] = true
            }
            if (j + 2 < n && visited[i][j + 2].not()) {
                result.add(Knight(i, j + 2, times + 1))
                visited[i][j + 2] = true
            }
            if (i + 2 < n && j - 1 >= 0 && visited[i + 2][j - 1].not()) {
                result.add(Knight(i + 2, j - 1, times + 1))
                visited[i + 2][j - 1] = true
            }
            if (i + 2 < n && j + 1 < n && visited[i + 2][j + 1].not()) {
                result.add(Knight(i + 2, j + 1, times + 1))
                visited[i + 2][j + 1] = true
            }

            return result
        }
    }

    val queue: Queue<Knight> = LinkedList()
    queue.offer(Knight(r1, c1, 0))
    visited[r1][c1] = true

    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        if (polled.i == r2 && polled.j == c2) {
            println(polled.times)
            return
        }

        queue.addAll(polled.getNexts())
    }

    println(-1)
}
