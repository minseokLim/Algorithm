package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

private val answers = StringJoiner(System.lineSeparator())
private var n = 0
private var m = 0
private lateinit var numbers: List<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val inputs = br.readLine().mapToIntList()
    n = inputs[0]
    m = inputs[1]

    numbers = br.readLine().mapToIntList().sorted()

    for (i in 0 until n) {
        solve(i, 1, StringBuilder())
    }

    println(answers)
}

private fun solve(srcIdx: Int, depth: Int, result: StringBuilder) {
    result.append("${numbers[srcIdx]} ")

    if (depth == m) {
        answers.add(result.trim().toString())
        return
    }

    for (i in srcIdx + 1 until n) {
        solve(i, depth + 1, StringBuilder(result))
    }
}

private fun String.mapToIntList(): List<Int> {
    return this.split(" ").map { it.toInt() }
}
