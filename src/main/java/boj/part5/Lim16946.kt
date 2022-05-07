package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { BooleanArray(m) }

    data class Dot(
        val i: Int,
        val j: Int
    ) {
        fun getClosedDots(): List<Dot> {
            return listOf(i - 1 to j, i + 1 to j, i to j - 1, i to j + 1)
                .filter { it.first in 0 until n && it.second in 0 until m && !map[it.first][it.second] }
                .map { Dot(it.first, it.second) }
        }

        fun getNextDots(visited: Array<BooleanArray>): List<Dot> {
            return listOf(i - 1 to j, i + 1 to j, i to j - 1, i to j + 1)
                .filter { it.first in 0 until n && it.second in 0 until m && !map[it.first][it.second] && !visited[it.first][it.second] }
                .map {
                    visited[it.first][it.second] = true
                    Dot(it.first, it.second)
                }
        }
    }

    val walls = mutableListOf<Dot>()

    for (i in 0 until n) {
        val input = br.readLine()
        for (j in 0 until m) {
            map[i][j] = input[j] == '1'
            if (map[i][j]) {
                walls.add(Dot(i, j))
            }
        }
    }

    data class Count(
        val index: Int,
        val count: Int
    )

    val visited = Array(n) { BooleanArray(m) }
    val indexes = Array(n) { IntArray(m) }
    val counts = mutableListOf<Count>()
    val answer = Array(n) { IntArray(m) }

    var k = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j].not() && visited[i][j].not()) {
                var count = 0
                val queue: Queue<Dot> = LinkedList()
                queue.offer(Dot(i, j))
                visited[i][j] = true
                val set = mutableSetOf<Dot>()

                while (queue.isNotEmpty()) {
                    val polled = queue.poll()
                    set.add(polled)
                    queue.addAll(polled.getNextDots(visited))
                    count++
                }

                set.forEach {
                    indexes[it.i][it.j] = k
                }
                counts.add(Count(k, count))
                k++
            }
        }
    }

    walls.forEach { wall ->
        answer[wall.i][wall.j] = (wall.getClosedDots().map { dot ->
            counts[indexes[dot.i][dot.j]]
        }.toSet().sumOf { it.count } + 1) % 10
    }

    println(answer.joinToString(System.lineSeparator()) { it.joinToString("") })
}

