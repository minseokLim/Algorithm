package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

private val answers = StringJoiner(System.lineSeparator())
private var n = 0
private var m = 0
private lateinit var numbers: List<Int>
private lateinit var result: MutableSet<Int>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val inputs = br.readLine().mapToIntList()
    n = inputs[0]
    m = inputs[1]

    numbers = br.readLine().mapToIntList().sorted()
    result = linkedSetOf()

    for (i in 0 until n) {
        solve(i, 1)
        result.remove(numbers[i])
    }

    println(answers)
}

private fun solve(srcIdx: Int, depth: Int) {
    result.add(numbers[srcIdx])

    if (depth == m) {
        answers.add(result.joinToString(" "))
        return
    }

    for (i in 0 until n) {
        if (result.contains(numbers[i])) {
            continue
        }
        solve(i, depth + 1)
        result.remove(numbers[i])
    }
}

private fun String.mapToIntList(): List<Int> {
    return this.split(" ").map { it.toInt() }
}
