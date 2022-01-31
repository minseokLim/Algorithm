package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val answer = StringJoiner(System.lineSeparator())
private var n = 0
private var m = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val inputs = br.readLine().split(" ").map { it.toInt() }
    n = inputs[0]
    m = inputs[1]

    for (i in 1..n) {
        solve(i, 1, StringBuilder())
    }

    println(answer)
}

private fun solve(target: Int, depth: Int, result: StringBuilder) {
    result.append(target.toString()).append(" ")

    if (depth == m) {
        answer.add(result.trim())
        return
    }

    for (i in 1..n) {
        solve(i, depth + 1, StringBuilder(result))
    }
}
