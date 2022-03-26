package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private var answer = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val (r, c, d) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { BooleanArray(m) }
    val visited = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        val input = br.readLine().split(" ")
        for (j in 0 until m) {
            map[i][j] = input[j] == "1"
        }
    }

    Robot(r, c, d).clean(n, m, map, visited)

    println(answer)
}

private class Robot(
    var i: Int,
    var j: Int,
    var d: Int
) {
    fun clean(n: Int, m: Int, map: Array<BooleanArray>, visited: Array<BooleanArray>) {
        visited[i][j] = true
        answer++

        search(n, m, 1, map, visited)
    }

    fun search(n: Int, m: Int, depth: Int, map: Array<BooleanArray>, visited: Array<BooleanArray>) {
        if (depth > 4) {
            val (newI, newJ) = getBackward()
            if (newI in 0 until n && newJ in 0 until m && map[newI][newJ].not()) {
                moveBackward()
                search(n, m, 1, map, visited)
            }

            return
        }

        counterClockwise()
        val (newI, newJ) = getForward()

        if (newI in 0 until n && newJ in 0 until m && visited[newI][newJ].not() && map[newI][newJ].not()) {
            moveForward()
            clean(n, m, map, visited)
        } else {
            search(n, m, depth + 1, map, visited)
        }
    }

    fun getForward(): Pair<Int, Int> {
        return when (d) {
            0 -> i - 1 to j
            1 -> i to j + 1
            2 -> i + 1 to j
            3 -> i to j - 1
            else -> throw IllegalArgumentException()
        }
    }

    fun getBackward(): Pair<Int, Int> {
        return when(d) {
            0 -> i + 1 to j
            1 -> i to j - 1
            2 -> i - 1 to j
            3 -> i to j + 1
            else -> throw IllegalArgumentException()
        }
    }

    fun counterClockwise() {
        when (d) {
            0 -> d = 3
            1 -> d = 0
            2 -> d = 1
            3 -> d = 2
        }
    }

    fun moveForward() {
        when (d) {
            0 -> i--
            1 -> j++
            2 -> i++
            3 -> j--
        }
    }

    fun moveBackward() {
        when (d) {
            0 -> i++
            1 -> j--
            2 -> i--
            3 -> j++
        }
    }
}
