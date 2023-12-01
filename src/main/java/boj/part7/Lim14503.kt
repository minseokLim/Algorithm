package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

private val directions = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
private var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val (r, c, d) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    repeat(n) {
        map[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var i = r
    var j = c
    var currentDirection = d
    while (true) {
        if (map[i][j] == 0) {
            count++
            map[i][j] = 2
        }

        val (nextI, nextJ, nextDirection) = getNextPosition(currentDirection, i, j, map)
        i = nextI
        j = nextJ
        currentDirection = nextDirection

        if (i == -1 && j == -1) {
            break
        }
    }

    println(count)
}

private fun getNextPosition(currentDirection: Int, currentI: Int, currentJ: Int, map: Array<IntArray>): Triple<Int, Int, Int> {
    var temp = currentDirection
    for (i in 0 until 4) {
        val nextDirection = rotate(temp)
        val nextI = currentI + directions[nextDirection].first
        val nextJ = currentJ + directions[nextDirection].second
        val nextPosition = map[nextI][nextJ]

        if (nextPosition == 0) {
            return Triple(nextI, nextJ, nextDirection)
        }
        temp = nextDirection
    }

    val backI = currentI - directions[currentDirection].first
    val backJ = currentJ - directions[currentDirection].second
    if (map[backI][backJ] != 1) {
        return Triple(backI, backJ, currentDirection)
    }

    return Triple(-1, -1, -1)
}

private fun rotate(currentDirection: Int): Int {
    return (currentDirection - 1 + 4) % 4
}
