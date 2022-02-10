package part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

private var n = 0
private var m = 0
private lateinit var numbers: List<Int>
private val answer = StringJoiner(System.lineSeparator())

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val firstInputs = br.extractNumbers()
    n = firstInputs[0]
    m = firstInputs[1]
    numbers = br.extractNumbers().sorted()

    for (i in 0 until n) {
        solve(1, "${numbers[i]}")
    }

    println(answer)
}

private fun BufferedReader.extractNumbers() = this.readLine().split(" ").map { it.toInt() }

private fun solve(depth: Int, seq: String) {
    if (depth == m) {
        answer.add(seq)
        return
    }

    for (i in 0 until n) {
        solve(depth + 1, "$seq ${numbers[i]}")
    }
}
