package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1, -1 to -1, -1 to 1, 1 to -1, 1 to 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { BooleanArray(m) }

    repeat(n) {
        map[it] = br.readLine().split(" ").map { it == "1" }.toBooleanArray()
    }

    class Dot(
        val i: Int,
        val j: Int,
        val distance: Int
    ) {
        fun setQueue(queue: Queue<Dot>, visited: Array<BooleanArray>) {
            directions.forEach {
                val nextI = i + it.first
                val nextJ = j + it.second

                if (nextI in 0 until n && nextJ in 0 until m && !visited[nextI][nextJ]) {
                    visited[nextI][nextJ] = true
                    queue.offer(Dot(nextI, nextJ, distance + 1))
                }
            }
        }
    }

    var max = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            var safetyDistance = 0

            if (!map[i][j]) {
                val visited = Array(n) { BooleanArray(m) }
                val queue: Queue<Dot> = LinkedList()
                queue.offer(Dot(i, j, 0))
                visited[i][j] = true

                while (queue.isNotEmpty()) {
                    val polled = queue.poll()

                    if (map[polled.i][polled.j]) {
                        safetyDistance = polled.distance
                        break
                    }

                    polled.setQueue(queue, visited)
                }
            }

            if (safetyDistance > max) {
                max = safetyDistance
            }
        }
    }

    println(max)
}
