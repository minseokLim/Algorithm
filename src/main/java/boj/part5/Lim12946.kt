package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private val directions = listOf(-1 to 0, -1 to 1, 0 to -1, 0 to 1, 1 to -1, 1 to 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val shouldBeColored = Array(n) { BooleanArray(n) }
    val visited = Array(n) { BooleanArray(n) }
    val hexagonColors = Array(n) { IntArray(n) }

    var zero = true
    var single = true
    var bipartied = true
    var solved = false

    for (i in 0 until n) {
        br.readLine()
            .toCharArray()
            .mapIndexed { j, c ->
                if (c == 'X') {
                    shouldBeColored[i][j] = true
                    zero = false
                }
            }
    }

    fun dfs(i: Int, j: Int, depth: Int, color: Int) {
        if (solved) {
            return
        }

        visited[i][j] = true
        hexagonColors[i][j] = color

        if (depth > 1) {
            single = false
        }

        val nextColor = color * -1
        for (direction in directions) {
            val nextI = i + direction.first
            val nextJ = j + direction.second

            if (nextI in 0 until n && nextJ in 0 until n && shouldBeColored[nextI][nextJ]) {
                if (visited[nextI][nextJ].not()) {
                    dfs(nextI, nextJ, depth + 1, nextColor)
                } else if (hexagonColors[nextI][nextJ] != nextColor) {
                    solved = true
                    bipartied = false
                    return
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (shouldBeColored[i][j] && visited[i][j].not()) {
                dfs(i, j, 1, 1)
            }
        }
    }

    if (zero) {
        println(0)
    } else if (single) {
        println(1)
    } else if (bipartied) {
        println(2)
    } else {
        println(3)
    }
}
