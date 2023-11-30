package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

private val heights = mutableListOf<Int>()
private val checked = BooleanArray(9)
private var solved = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat(9) {
        heights.add(br.readLine().toInt())
    }

    for (i in 0..2) {
        if (solved) break

        solve(i, 1)
        checked[i] = false
    }
}

private fun solve(idx: Int, depth: Int) {
    checked[idx] = true
    if (depth == 7) {
        val result = heights.filterIndexed { index, _ -> checked[index] }
        if (result.sum() == 100) {
            result.sorted().forEach { println(it) }
            solved = true
        }
        return
    }

    for (i in idx + 1 until 9) {
        if (solved) break

        solve(i, depth + 1)
        checked[i] = false
    }
}
