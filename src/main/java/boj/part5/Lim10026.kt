package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val image = Array(n) { CharArray(n) }
    var visited = Array(n) { BooleanArray(n) }

    repeat(n) {
        image[it] = br.readLine().toCharArray()
    }

    fun equals(i1: Int, j1: Int, i2: Int, j2: Int, colorWeak: Boolean): Boolean {
        return if (!colorWeak) {
            image[i1][j1] == image[i2][j2]
        } else {
            image[i1][j1] == image[i2][j2] || (image[i1][j1] == 'R' && image[i2][j2] == 'G') || (image[i1][j1] == 'G' && image[i2][j2] == 'R')
        }
    }

    fun dfs(i: Int, j: Int, colorWeak: Boolean = false) {
        visited[i][j] = true

        val list = listOf(i - 1 to j, i + 1 to j, i to j - 1, i to j + 1)
            .filter {
                it.first in 0 until n && it.second in 0 until n && equals(
                    i,
                    j,
                    it.first,
                    it.second,
                    colorWeak
                )
            }

        list.forEach {
            if (!visited[it.first][it.second]) {
                dfs(it.first, it.second, colorWeak)
            }
        }
    }

    var normalCount = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visited[i][j].not()) {
                dfs(i, j)
                normalCount++
            }
        }
    }

    visited = Array(n) { BooleanArray(n) }
    var colorWeakCount = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visited[i][j].not()) {
                dfs(i, j, true)
                colorWeakCount++
            }
        }
    }

    println("$normalCount $colorWeakCount")
}
