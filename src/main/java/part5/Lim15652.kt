package part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

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

private fun solve(element: Int, depth: Int, sb: StringBuilder) {
    sb.append(element).append(" ")

    if (depth == m) {
        answer.add(sb)
        return
    }

    for (i in element..n) {
        solve(i, depth + 1, StringBuilder(sb))
    }
}
