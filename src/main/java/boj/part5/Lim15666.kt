package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted()
    val answer = StringJoiner(System.lineSeparator())

    fun dfs(idx: Int, element: String, depth: Int) {
        if (depth == m) {
            answer.add(element)
            return
        }

        var before = -1
        for (i in idx until n) {
            if (numbers[i] != before) {
                dfs(i, "$element ${numbers[i]}", depth + 1)
                before = numbers[i]
            }
        }
    }

    var before = -1
    for (i in 0 until n) {
        if (numbers[i] != before) {
            dfs(i, numbers[i].toString(), 1)
            before = numbers[i]
        }
    }

    println(answer)
}
