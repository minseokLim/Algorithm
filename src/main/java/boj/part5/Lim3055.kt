package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(r) { CharArray(c) }
    val visited = Array(r) { BooleanArray(c) }

    data class Water(
        val i: Int,
        val j: Int
    ) {
        fun getNext(): List<Water> {
            return directions.filter {
                val nextI = i + it.first
                val nextJ = j + it.second
                nextI in 0 until r && nextJ in 0 until c && map[nextI][nextJ] != '*' && map[nextI][nextJ] != 'X' && map[nextI][nextJ] != 'D'
            }.map {
                val nextI = i + it.first
                val nextJ = j + it.second
                map[nextI][nextJ] = '*'

                Water(nextI, nextJ)
            }
        }
    }

    class Sonic(
        val i: Int,
        val j: Int,
        val numberOfMoves: Int
    ) {
        fun isReached(): Boolean {
            return map[i][j] == 'D'
        }

        fun setQueue(queue: Queue<Sonic>) {
            directions.filter {
                val nextI = i + it.first
                val nextJ = j + it.second
                nextI in 0 until r && nextJ in 0 until c && !visited[nextI][nextJ] && map[nextI][nextJ] != 'X' && map[nextI][nextJ] != '*'
            }.forEach {
                val nextI = i + it.first
                val nextJ = j + it.second
                visited[nextI][nextJ] = true

                queue.offer(Sonic(nextI, nextJ, numberOfMoves + 1))
            }
        }
    }

    val waters: Queue<Water> = LinkedList()
    val sonics: Queue<Sonic> = LinkedList()
    for (i in 0 until r) {
        val input = br.readLine().toCharArray()
        for (j in 0 until c) {
            map[i][j] = input[j]

            when (map[i][j]) {
                '*' -> waters.offer(Water(i, j))
                'S' -> sonics.offer(Sonic(i, j, 0))
            }
        }
    }

    var currentTime = -1
    while (sonics.isNotEmpty()) {
        val polled = sonics.poll()

        if (polled.isReached()) {
            println(polled.numberOfMoves)
            return
        }

        if (currentTime != polled.numberOfMoves) {
            currentTime = polled.numberOfMoves
            val nextWaters = mutableSetOf<Water>()

            while (waters.isNotEmpty()) {
                val polledWater = waters.poll()
                nextWaters.addAll(polledWater.getNext())
            }

            waters.addAll(nextWaters)
        }

        polled.setQueue(sonics)
    }

    println("KAKTUS")
}
