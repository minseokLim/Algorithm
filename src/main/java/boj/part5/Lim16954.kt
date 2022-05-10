package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1, -1 to 1, -1 to -1, 1 to 1, 1 to -1)
private val initialRow = BooleanArray(8) { true }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val chessBoard = Array(8) { BooleanArray(8) }
    val visited = Array(8) { BooleanArray(8) }

    repeat(8) { idx ->
        chessBoard[idx] = br.readLine().map { it == '.' }.toBooleanArray()
    }

    class Wookjae(
        val i: Int,
        val j: Int,
        val times: Int
    ) {
        fun setQueue(queue: Queue<Wookjae>) {
            directions.forEach {
                val nextI = i + it.first
                val nextJ = j + it.second
                if (nextI in 0 until 8 && nextJ in 0 until 8 && !visited[nextI][nextJ] && chessBoard[nextI][nextJ] && (nextI == 0 || chessBoard[nextI - 1][nextJ])) {
                    visited[nextI][nextJ] = true
                    queue.offer(Wookjae(nextI, nextJ, times + 1))
                }
            }

            if (i == 0 || chessBoard[i - 1][j]) {
                queue.offer(Wookjae(i, j, times + 1))
            }
        }
    }

    var times = 0
    val queue: Queue<Wookjae> = LinkedList()
    queue.offer(Wookjae(7, 0, times))
    visited[7][0] = true

    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled.times != times) {
            chessBoard.moveWall()
            times = polled.times
        }

        if ((polled.i == 0 && polled.j == 7) || polled.times == 8) {
            println(1)
            return
        }

        polled.setQueue(queue)
    }

    println(0)
}

private fun Array<BooleanArray>.moveWall() {
    for (i in 6 downTo 0) {
        this[i + 1] = this[i]
    }
    this[0] = initialRow
}
