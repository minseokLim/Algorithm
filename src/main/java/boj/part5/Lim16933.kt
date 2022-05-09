package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        map[i] = br.readLine().map { it == '1' }.toBooleanArray()
    }

    val breakableCounts = Array(n) { IntArray(m) { -1 } }
    val visited = Array(n) { Array(m) { BooleanArray(k + 1) } }

    class Mover(
        val i: Int,
        val j: Int,
        val breakableCount: Int,
        val times: Int = 1
    ) {
        fun setQueue(queue: Queue<Mover>) {
            val directions = listOf(i - 1 to j, i + 1 to j, i to j - 1, i to j + 1)

            if (times.and(1) == 1) {
                directions.forEach {
                    if (it.first in 0 until n && it.second in 0 until m && !visited[it.first][it.second][breakableCount] && (breakableCount > 0 || !map[it.first][it.second])) {
                        visited[it.first][it.second][breakableCount] = true

                        if (breakableCount > breakableCounts[it.first][it.second]) {
                            breakableCounts[it.first][it.second] = breakableCount

                            if (breakableCount > 0 && map[it.first][it.second]) {
                                queue.add(Mover(it.first, it.second, breakableCount - 1, times + 1))
                            } else {
                                queue.add(Mover(it.first, it.second, breakableCount, times + 1))
                            }
                        }
                    }
                }
            } else {
                directions.forEach {
                    if (it.first in 0 until n && it.second in 0 until m && !visited[it.first][it.second][breakableCount] &&
                        if (breakableCount > 0) {
                            true
                        } else {
                            !map[it.first][it.second]
                        }
                    ) {
                        if (breakableCount > 0 && map[it.first][it.second]) {
                            queue.add(Mover(i, j, breakableCount, times + 1))
                        } else {
                            visited[it.first][it.second][breakableCount] = true

                            if (breakableCount > breakableCounts[it.first][it.second]) {
                                breakableCounts[it.first][it.second] = breakableCount
                                queue.add(Mover(it.first, it.second, breakableCount, times + 1))
                            }
                        }
                    }
                }
            }
        }
    }

    val queue: Queue<Mover> = LinkedList()
    queue.offer(Mover(0, 0, k))
    visited[0][0][k] = true

    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled.i == n - 1 && polled.j == m - 1) {
            println(polled.times)
            return
        }

        polled.setQueue(queue)
    }

    println(-1)
}
