package part5

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

    val numbers = linkedSetOf<Int>()
    solve(numbers)

    println(answer)
}

private fun solve(numbers: MutableSet<Int>) {
    for (i in 1..n) {
        if (numbers.contains(i)) {
            continue
        }
        accumulate(numbers, i)
        numbers.remove(i)
    }
}

private fun accumulate(numbers: MutableSet<Int>, element: Int) {
    numbers.add(element)

    if (numbers.size == m) {
        answer.add(numbers.joinToString(" "))
        return
    }

    solve(numbers)
}
