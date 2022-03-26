package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private val visited = Array(101) { BooleanArray(101) }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    repeat(n) {
        val (x, y, d, g) = br.readLine().split(" ").map { it.toInt() }
        drawDragonCurve(x, y, d, g)
    }

    var answer = 0

    for (i in 0 until 100) {
        for (j in 0 until 100) {
            if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
                answer++
            }
        }
    }

    println(answer)
}

private fun drawDragonCurve(x: Int, y: Int, d: Int, g: Int) {
    val start = x to y
    visited[x][y] = true

    var end = when (d) {
        0 -> x + 1 to y
        1 -> x to y - 1
        2 -> x - 1 to y
        3 -> x to y + 1
        else -> throw IllegalArgumentException()
    }
    visited[end.first][end.second] = true

    val dots = mutableSetOf(start, end)

    repeat(g) {
        val addedDots = mutableSetOf<Pair<Int, Int>>()
        for (dot in dots) {
            val rotatedDot = rotate(end, dot)
            visited[rotatedDot.first][rotatedDot.second] = true
            addedDots.add(rotatedDot)
        }
        dots.addAll(addedDots)

        end = rotate(end, start)
    }
}

private fun rotate(
    base: Pair<Int, Int>,
    dot: Pair<Int, Int>
) = base.second - dot.second + base.first to dot.first - base.first + base.second
