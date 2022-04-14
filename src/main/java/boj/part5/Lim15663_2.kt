package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private val answers = mutableListOf<String>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.extractNumbers()
    val numbers = br.extractNumbers().sorted()

    val visited = BooleanArray(n)
    val sequence = IntArray(m)
    for (i in 0 until n) {
        solve(i, 0, sequence, numbers, visited)
        visited[i] = false
    }

    val answer = answers.distinct().joinToString(System.lineSeparator())

    println(answer)
}

private fun BufferedReader.extractNumbers() = this.readLine().split(" ").map { it.toInt() }

private fun solve(idx: Int, depth: Int, sequence: IntArray, numbers: List<Int>, visited: BooleanArray) {
    sequence[depth] = numbers[idx]
    visited[idx] = true

    if (depth == sequence.size - 1) {
        answers.add(sequence.joinToString(" "))
        return
    }

    for (i in numbers.indices) {
        if (visited[i].not()) {
            solve(i, depth + 1, sequence, numbers, visited)
            visited[i] = false
        }
    }
}
