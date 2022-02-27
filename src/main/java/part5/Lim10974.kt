package part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

private var n = 0
private lateinit var checked: BooleanArray
private val answer = StringJoiner(System.lineSeparator())

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    checked = BooleanArray(n + 1)

    for (i in 1..n) {
        val numbers = linkedSetOf<Int>()
        solve(i, numbers, 1);
        checked[i] = false
        numbers.remove(i)
    }

    println(answer)
}

private fun solve(element: Int, numbers: MutableSet<Int>, depth: Int) {
    checked[element] = true
    numbers.add(element)

    if (depth == n) {
        answer.add(numbers.joinToString(" "))
        return
    }

    for (i in 1..n) {
        if (!checked[i]) {
            solve(i, numbers, depth + 1)
            checked[i] = false
            numbers.remove(i)
        }
    }
}
