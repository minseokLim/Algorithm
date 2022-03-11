package part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, x, y, k) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            map[i][j] = input[j]
        }
    }

    val commands = br.readLine().split(" ").map { it.toInt() }
    var (currentI, currentJ) = x to y
    val dice = Dice()

    val answer = commands.mapNotNull {
        val nextPosition = Dice.computeNextPosition(it, currentI, currentJ, n, m)

        if (nextPosition != null) {
            currentI = nextPosition.first
            currentJ = nextPosition.second
            dice.roll(it, map, currentI, currentJ)
            dice.top.toString()
        } else {
            null
        }
    }.joinToString(System.lineSeparator())

    println(answer)
}

private class Dice {
    var top = 0
    var bottom = 0
    var west = 0
    var east = 0
    var north = 0
    var south = 0

    companion object {
        fun computeNextPosition(command: Int, i: Int, j: Int, n: Int, m: Int): Pair<Int, Int>? {
            val (nextI, nextJ) = when (command) {
                1 -> i to j + 1
                2 -> i to j - 1
                3 -> i - 1 to j
                4 -> i + 1 to j
                else -> throw IllegalArgumentException()
            }

            if (nextI !in 0 until n || nextJ !in 0 until m) {
                return null
            }

            return nextI to nextJ
        }
    }

    fun roll(command: Int, map: Array<IntArray>, nextI: Int, nextJ: Int) {
        when (command) {
            1 -> {
                val tmp = top
                top = west
                west = bottom
                bottom = east
                east = tmp
            }
            2 -> {
                val tmp = top
                top = east
                east = bottom
                bottom = west
                west = tmp
            }
            3 -> {
                val tmp = top
                top = south
                south = bottom
                bottom = north
                north = tmp
            }
            4 -> {
                val tmp = top
                top = north
                north = bottom
                bottom = south
                south = tmp
            }
        }
        if (map[nextI][nextJ] == 0) {
            map[nextI][nextJ] = bottom
        } else {
            bottom = map[nextI][nextJ]
            map[nextI][nextJ] = 0
        }
    }
}
