package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

private var n = 0
private var m = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    val board = Array(n) { CharArray(m) }
    var red = Pos(0, 0)
    var blue = Pos(0, 0)

    for (i in 0 until n) {
        board[i] = br.readLine().toCharArray()
        for (j in 0 until m) {
            if (board[i][j] == 'R') {
                red = Pos(i, j)
            }
            if (board[i][j] == 'B') {
                blue = Pos(i, j)
            }
        }
    }

    var answer = -1
    val queue = LinkedList<Status>()
    queue.offer(Status(board, 0, setOf(red.getVisited() to blue.getVisited())))

    outer@ while (queue.isNotEmpty()) {
        val polled = queue.poll()

        for (direction in DIRECTION.values()) {
            val movedStatus = polled.move(direction)

            if (movedStatus.count > 10) {
                break@outer
            }

            if (movedStatus.check()) {
                answer = movedStatus.count
                break@outer
            }

            if (polled.visited.size == movedStatus.visited.size) {
                continue
            }

            queue.offer(movedStatus)
        }
    }

    println(answer)
}

private class Pos(
    val i: Int,
    val j: Int
) {
    fun getVisited(): Long {
        return 1L shl ((i - 1) * (m - 2) + (j - 1))
    }
}

private enum class DIRECTION {
    LEFT, RIGHT, TOP, BOTTOM
}

private class Status(
    val board: Array<CharArray>,
    val count: Int,
    val visited: Set<Pair<Long, Long>>
) {
    fun check(): Boolean {
        var red = false
        var blue = false

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (board[i][j] == 'R') {
                    red = true
                }
                if (board[i][j] == 'B') {
                    blue = true
                }
            }
        }

        return !red && blue
    }

    fun move(
        direction: DIRECTION
    ): Status {
        val result = board.map { it.copyOf() }.toTypedArray()
        val newVisited = HashSet(visited)
        var newRedVisited = 0L
        var newBlueVisited = 0L

        when (direction) {
            DIRECTION.LEFT -> {
                for (j in 1..m - 2) {
                    for (i in 1..n - 2) {
                        if (result[i][j] == 'R') {
                            var temp = j
                            while (result[i][temp - 1] == '.') {
                                result.swap(i, temp, i, temp - 1)
                                temp--
                            }
                            if (result[i][temp - 1] == 'O') {
                                result[i][temp] = '.'
                                newRedVisited = Pos(i, temp - 1).getVisited()
                            } else {
                                newRedVisited = Pos(i, temp).getVisited()
                            }
                        }

                        if (result[i][j] == 'B') {
                            var temp = j
                            while (result[i][temp - 1] == '.') {
                                result.swap(i, temp, i, temp - 1)
                                temp--
                            }
                            if (result[i][temp - 1] == 'O') {
                                result[i][temp] = '.'
                                newBlueVisited = Pos(i, temp - 1).getVisited()
                            } else {
                                newBlueVisited = Pos(i, temp).getVisited()
                            }
                        }
                    }
                }
            }
            DIRECTION.RIGHT -> {
                for (j in m - 2 downTo 1) {
                    for (i in 1..n - 2) {
                        if (result[i][j] == 'R') {
                            var temp = j
                            while (result[i][temp + 1] == '.') {
                                result.swap(i, temp, i, temp + 1)
                                temp++
                            }
                            if (result[i][temp + 1] == 'O') {
                                result[i][temp] = '.'
                                newRedVisited = Pos(i, temp + 1).getVisited()
                            } else {
                                newRedVisited = Pos(i, temp).getVisited()
                            }
                        }

                        if (result[i][j] == 'B') {
                            var temp = j
                            while (result[i][temp + 1] == '.') {
                                result.swap(i, temp, i, temp + 1)
                                temp++
                            }
                            if (result[i][temp + 1] == 'O') {
                                result[i][temp] = '.'
                                newBlueVisited = Pos(i, temp + 1).getVisited()
                            } else {
                                newBlueVisited = Pos(i, temp).getVisited()
                            }
                        }
                    }
                }
            }
            DIRECTION.TOP -> {
                for (i in 1..n - 2) {
                    for (j in 1..m - 2) {
                        if (result[i][j] == 'R') {
                            var temp = i
                            while (result[temp - 1][j] == '.') {
                                result.swap(temp, j, temp - 1, j)
                                temp--
                            }
                            if (result[temp - 1][j] == 'O') {
                                result[temp][j] = '.'
                                newRedVisited = Pos(temp - 1, j).getVisited()
                            } else {
                                newRedVisited = Pos(temp, j).getVisited()
                            }
                        }

                        if (result[i][j] == 'B') {
                            var temp = i
                            while (result[temp - 1][j] == '.') {
                                result.swap(temp, j, temp - 1, j)
                                temp--
                            }
                            if (result[temp - 1][j] == 'O') {
                                result[temp][j] = '.'
                                newBlueVisited = Pos(temp - 1, j).getVisited()
                            } else {
                                newBlueVisited = Pos(temp, j).getVisited()
                            }
                        }
                    }
                }
            }
            DIRECTION.BOTTOM -> {
                for (i in n - 2 downTo 1) {
                    for (j in 1..m - 2) {
                        if (result[i][j] == 'R') {
                            var temp = i
                            while (result[temp + 1][j] == '.') {
                                result.swap(temp, j, temp + 1, j)
                                temp++
                            }
                            if (result[temp + 1][j] == 'O') {
                                result[temp][j] = '.'
                                newRedVisited = Pos(temp + 1, j).getVisited()
                            } else {
                                newRedVisited = Pos(temp, j).getVisited()
                            }

                        }

                        if (result[i][j] == 'B') {
                            var temp = i
                            while (result[temp + 1][j] == '.') {
                                result.swap(temp, j, temp + 1, j)
                                temp++
                            }
                            if (result[temp + 1][j] == 'O') {
                                result[temp][j] = '.'
                                newBlueVisited = Pos(temp + 1, j).getVisited()
                            } else {
                                newBlueVisited = Pos(temp, j).getVisited()
                            }
                        }
                    }
                }
            }
        }

        newVisited.add(newRedVisited to newBlueVisited)
        return Status(result, count + 1, newVisited)
    }
}

private fun Array<CharArray>.swap(beforeI: Int, beforeJ: Int, afterI: Int, afterJ: Int) {
    val temp = this[beforeI][beforeJ]
    this[beforeI][beforeJ] = this[afterI][afterJ]
    this[afterI][afterJ] = temp
}
