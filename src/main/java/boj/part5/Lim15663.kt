package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

private var n = 0
private var m = 0
private lateinit var numbers: List<Int>
private val answer = mutableSetOf<String>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val firstInputs = br.extractNumbers()
    n = firstInputs[0]
    m = firstInputs[1]
    numbers = br.extractNumbers().sorted()

    for (i in 0 until n) {
        solve(i, 1, mutableListOf(numbers[i]))
    }

    println(answer.joinToString(System.lineSeparator()))
}

private fun BufferedReader.extractNumbers() = this.readLine().split(" ").map { it.toInt() }

private fun solve(idx: Int, depth: Int, list: MutableList<Int>) {
    if (depth == m) {
        answer.add(list.joinToString(" "))
        return
    }

    for (i in 0 until n) {
        if (i != idx) {
            list.add(numbers[i])
            solve(i, depth + 1, list)
            list.remove(numbers[i])
        }
    }
}
