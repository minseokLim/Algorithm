package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (w, h) = br.readLine().split(" ").map { it.toInt() }
    val map: Array<CharArray?> = Array(h) { null }
    val visited = Array(h) { BooleanArray(w) }

    repeat(h) {
        map[it] = br.readLine().toCharArray()
    }

    class Laser(
        val i: Int,
        val j: Int,
        val mirrorCount: Int
    ) {
        fun setNextInQueue(queue: Queue<Laser>) {
            directions.forEach {
                var multiplier = 1

                var nextI = i + it.first * multiplier
                var nextJ = j + it.second * multiplier
                while (nextI in 0 until h && nextJ in 0 until w && map[nextI]!![nextJ] != '*') {
                    if (!visited[nextI][nextJ]) {
                        visited[nextI][nextJ] = true
                        queue.offer(Laser(nextI, nextJ, mirrorCount + 1))
                    }

                    multiplier++
                    nextI = i + it.first * multiplier
                    nextJ = j + it.second * multiplier
                }
            }
        }
    }

    for (i in 0 until h) {
        for (j in 0 until w) {
            if (map[i]!![j] == 'C') {
                val queue: Queue<Laser> = LinkedList()
                queue.offer(Laser(i, j, 0))
                visited[i][j] = true

                while (queue.isNotEmpty()) {
                    val polled = queue.poll()

                    if (map[polled.i]!![polled.j] == 'C' && (polled.i != i || polled.j != j)) {
                        println(polled.mirrorCount - 1)
                        return
                    }

                    polled.setNextInQueue(queue)
                }

                return
            }
        }
    }
}
