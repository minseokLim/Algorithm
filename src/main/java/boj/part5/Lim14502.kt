package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(n) { IntArray(m) }

    class Position(
        val i: Int,
        val j: Int
    ) {
        fun getNextPositions(visited: Array<BooleanArray>): List<Position> {
            return listOf(i + 1 to j, i - 1 to j, i to j + 1, i to j - 1)
                .filter { it.first in 0 until n && it.second in 0 until m && !visited[it.first][it.second] && map[it.first][it.second] == 0 }
                .map {
                    visited[it.first][it.second] = true
                    Position(it.first, it.second)
                }
        }
    }

    val virusPositions = mutableListOf<Position>()
    var emptyCount = 0

    for (i in 0 until n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            map[i][j] = input[j]

            when (map[i][j]) {
                2 -> virusPositions.add(Position(i, j))
                0 -> emptyCount++
            }
        }
    }

    var answer = 0

    fun setWall(iIdx: Int, jIdx: Int, depth: Int) {
        map[iIdx][jIdx] = 1

        if (depth == 3) {
            val visited = Array(n) { BooleanArray(m) }
            val queue: Queue<Position> = LinkedList()
            queue.addAll(virusPositions)
            var spreadCount = 0

            while (queue.isNotEmpty()) {
                val polled = queue.poll()

                val nextPositions = polled.getNextPositions(visited)
                spreadCount += nextPositions.size
                queue.addAll(nextPositions)
            }

            if (emptyCount - spreadCount - 3 > answer) {
                answer = emptyCount - spreadCount - 3
            }

            return
        }

        val nextX = iIdx * m + jIdx + 1

        for (x in nextX until n * m) {
            val i = x / m
            val j = x - i * m

            if (map[i][j] == 0) {
                setWall(i, j, depth + 1)
                map[i][j] = 0
            }
        }
    }

    for (x in 0 until n * m) {
        val i = x / m
        val j = x - i * m

        if (map[i][j] == 0) {
            setWall(i, j, 1)
            map[i][j] = 0
        }
    }

    println(answer)
}
