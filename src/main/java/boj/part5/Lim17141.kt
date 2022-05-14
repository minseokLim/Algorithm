package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(n) }

    class Position(
        val i: Int,
        val j: Int,
        val times: Int
    ) {
        fun setQueue(queue: Queue<Position>, visited: Array<BooleanArray>) {
            directions.forEach {
                val nextI = i + it.first
                val nextJ = j + it.second

                if (nextI in 0 until n && nextJ in 0 until n && !visited[nextI][nextJ] && map[nextI][nextJ] != 1) {
                    visited[nextI][nextJ] = true
                    queue.offer(Position(nextI, nextJ, times + 1))
                }
            }
        }
    }

    var emptyCount = 0
    val virusPositions = mutableListOf<Position>()

    for (i in 0 until n) {
        val input = br.readLine().split(" ").map { it.toInt() }

        for (j in 0 until n) {
            map[i][j] = input[j]
            if (map[i][j] == 0 || map[i][j] == 2) {
                emptyCount++
            }
            if (map[i][j] == 2) {
                virusPositions.add(Position(i, j, 0))
            }
        }
    }
    var answer = Int.MAX_VALUE
    val positionPicked = BooleanArray(virusPositions.size)

    fun solve(targetIdx: Int, depth: Int) {
        positionPicked[targetIdx] = true

        if (depth == m) {
            val visited = Array(n) { BooleanArray(n) }
            val queue: Queue<Position> = LinkedList()
            val pickedVirusPositions = virusPositions.filterIndexed { idx, _ -> positionPicked[idx] }
            queue.addAll(pickedVirusPositions)
            pickedVirusPositions.forEach {
                visited[it.i][it.j] = true
            }

            var time = 0
            var count = 0

            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                count++

                if (time != polled.times) {
                    time = polled.times
                }

                polled.setQueue(queue, visited)
            }

            if (count == emptyCount && answer > time) {
                answer = time
            }

            return
        }

        for (i in targetIdx + 1 until virusPositions.size) {
            solve(i, depth + 1)
            positionPicked[i] = false
        }
    }

    for (i in 0 until virusPositions.size) {
        solve(i, 1)
        positionPicked[i] = false
    }

    if (answer == Int.MAX_VALUE) {
        answer = -1
    }

    println(answer)
}
