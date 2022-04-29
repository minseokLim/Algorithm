package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { BooleanArray(m) }
    val visited = Array(n) { Array(m) { BooleanArray(2) } }

    for (i in 0 until n) {
        val input = br.readLine().toCharArray()
        for (j in 0 until m) {
            map[i][j] = input[j] == '1'
        }
    }

    class Spot(
        val i: Int,
        val j: Int,
        val times: Int,
        val useDestroy: Boolean = false
    ) {
        fun getNextSpots(): List<Spot> {
            val next = directions.map { i + it.first to j + it.second }
                .filter { it.first in 0 until n && it.second in 0 until m }

            return if (useDestroy) {
                next.filter { !map[it.first][it.second] && !visited[it.first][it.second][1] }
                    .map {
                        visited[it.first][it.second][1] = true
                        Spot(it.first, it.second, times + 1, true)
                    }
            } else {
                next.filter { !visited[it.first][it.second][0] }
                    .map {
                        visited[it.first][it.second][0] = true
                        if (map[it.first][it.second]) {
                            Spot(it.first, it.second, times + 1, true)
                        } else {
                            Spot(it.first, it.second, times + 1, false)
                        }
                    }
            }
        }
    }

    val queue: Queue<Spot> = LinkedList()
    queue.offer(Spot(0, 0, 1))
    visited[0][0][0] = true

    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled.i == n - 1 && polled.j == m - 1) {
            println(polled.times)
            return
        }

        val nextSpots = polled.getNextSpots()
        queue.addAll(nextSpots)
    }

    println(-1)
}
