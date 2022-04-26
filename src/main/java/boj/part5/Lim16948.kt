package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val (r1, c1, r2, c2) = br.readLine().split(" ").map { it.toInt() }

    val directions = listOf(-2 to -1, -2 to 1, 0 to -2, 0 to 2, 2 to -1, 2 to 1)
    val visited = Array(n) { BooleanArray(n) }

    class DeathKnight(
        val r: Int,
        val c: Int,
        val times: Int
    ) {
        fun getNextKnights(): List<DeathKnight> {
            return directions
                .filter { r + it.first in 0 until n && c + it.second in 0 until n && !visited[r + it.first][c + it.second] }
                .map {
                    visited[r + it.first][c + it.second] = true
                    DeathKnight(r + it.first, c + it.second, times + 1)
                }
        }
    }

    var answer = -1

    val queue: Queue<DeathKnight> = LinkedList()
    queue.offer(DeathKnight(r1, c1, 0))
    visited[r1][c1] = true

    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled.r == r2 && polled.c == c2) {
            answer = polled.times
            break
        }

        queue.addAll(polled.getNextKnights())
    }

    println(answer)
}
