package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val answer = StringJoiner(System.lineSeparator())

    outer@ while (true) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        if (w == 0 && h == 0) {
            break
        }

        val room = Array(h) { CharArray(w) }

        class Robot(
            val i: Int,
            val j: Int,
            val numberOfMoves: Int = 0
        ) {
            fun setQueue(queue: Queue<Robot>, visited: Array<BooleanArray>) {
                directions.filter {
                    val nextI = i + it.first
                    val nextJ = j + it.second
                    nextI in 0 until h && nextJ in 0 until w && room[nextI][nextJ] != 'x' && !visited[nextI][nextJ]
                }.forEach {
                    val nextI = i + it.first
                    val nextJ = j + it.second
                    visited[nextI][nextJ] = true
                    queue.offer(Robot(nextI, nextJ, numberOfMoves + 1))
                }
            }
        }

        class Point(
            val i: Int,
            val j: Int
        ) {
            fun toRobot(): Robot {
                return Robot(i, j)
            }

            fun equalsRobot(robot: Robot): Boolean {
                return robot.i == i && robot.j == j
            }
        }

        val dirtyPoints = mutableListOf<Point>()
        var initialRobotPoint: Point? = null
        repeat(h) {
            val input = br.readLine().toCharArray()
            for (i in 0 until w) {
                room[it][i] = input[i]
                if (room[it][i] == '*') {
                    dirtyPoints.add(Point(it, i))
                } else if (room[it][i] == 'o') {
                    initialRobotPoint = Point(it, i)
                }
            }
        }

        val distances = Array(dirtyPoints.size) { IntArray(dirtyPoints.size) }
        for (i in 0 until dirtyPoints.size) {
            inner@ for (j in 0 until dirtyPoints.size) {
                if (i != j && distances[i][j] == 0) {
                    val queue: Queue<Robot> = LinkedList()
                    queue.offer(dirtyPoints[i].toRobot())
                    val visited = Array(h) { BooleanArray(w) }
                    visited[dirtyPoints[i].i][dirtyPoints[i].j] = true

                    while (queue.isNotEmpty()) {
                        val polled = queue.poll()

                        if (dirtyPoints[j].equalsRobot(polled)) {
                            distances[i][j] = polled.numberOfMoves
                            distances[j][i] = polled.numberOfMoves
                            continue@inner
                        }

                        polled.setQueue(queue, visited)
                    }

                    answer.add((-1).toString())
                    continue@outer
                }
            }
        }

        val robotToDirtDistances = IntArray(dirtyPoints.size)
        inner@ for (i in 0 until dirtyPoints.size) {
            val queue: Queue<Robot> = LinkedList()
            queue.offer(dirtyPoints[i].toRobot())
            val visited = Array(h) { BooleanArray(w) }
            visited[dirtyPoints[i].i][dirtyPoints[i].j] = true

            while (queue.isNotEmpty()) {
                val polled = queue.poll()

                if (initialRobotPoint!!.equalsRobot(polled)) {
                    robotToDirtDistances[i] = polled.numberOfMoves
                    continue@inner
                }

                polled.setQueue(queue, visited)
            }

            answer.add((-1).toString())
            continue@outer
        }
        var min = Int.MAX_VALUE
        val visited = Array(h) { BooleanArray(w) }
        fun dfs(idx: Int, distance: Int, depth: Int) {
            visited[dirtyPoints[idx].i][dirtyPoints[idx].j] = true
            if (depth == dirtyPoints.size) {
                if (distance < min) {
                    min = distance
                }
                return
            }

            for (i in 0 until dirtyPoints.size) {
                if (!visited[dirtyPoints[i].i][dirtyPoints[i].j]) {
                    dfs(i, distance + distances[i][idx], depth + 1)
                    visited[dirtyPoints[i].i][dirtyPoints[i].j] = false
                }
            }
        }

        for (i in 0 until dirtyPoints.size) {
            dfs(i, robotToDirtDistances[i], 1)
            visited[dirtyPoints[i].i][dirtyPoints[i].j] = false
        }

        answer.add(min.toString())
    }

    println(answer)
}
