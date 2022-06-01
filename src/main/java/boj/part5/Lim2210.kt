package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val map = Array(5) { IntArray(5) }

    for (i in 0 until 5) {
        map[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val answers = mutableSetOf<String>()
    fun dfs(currentI: Int, currentJ: Int, number: String, depth: Int) {
        if (depth == 5) {
            answers.add(number)
            return
        }

        directions
            .filter { currentI + it.first in 0 until 5 && currentJ + it.second in 0 until 5 }
            .forEach {
                val nextI = currentI + it.first
                val nextJ = currentJ + it.second
                dfs(nextI, nextJ, "$number${map[nextI][nextJ]}", depth + 1)
            }
    }

    for (i in 0 until 5) {
        for (j in 0 until 5) {
            dfs(i, j, map[i][j].toString(), 0)
        }
    }

    println(answers.size)
}
