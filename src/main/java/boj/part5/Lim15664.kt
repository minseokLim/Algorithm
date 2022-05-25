package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted()
    val answerSet = LinkedHashSet<String>()
    val checked = BooleanArray(n)

    fun dfs(idx: Int, depth: Int) {
        checked[idx] = true
        if (depth == m) {
            answerSet.add(numbers.filterIndexed { index, _ -> checked[index] }.joinToString(" "))
            return
        }

        for (i in idx + 1 until n) {
            dfs(i, depth + 1)
            checked[i] = false
        }
    }

    for (i in 0 until n) {
        dfs(i, 1)
        checked[i] = false
    }

    println(answerSet.joinToString(System.lineSeparator()))
}
