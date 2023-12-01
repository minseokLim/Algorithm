package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

private val partSums = mutableSetOf<Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val s = br.readLine().split(" ").map { it.toInt() }

    for (i in 0 until n) {
        partSums.add(s[i])
        search(i, s, s[i], n)
    }

    var answer = 1
    val sortedPartSums = partSums.sorted()

    while (true) {
        if (answer - 1 >= sortedPartSums.size || answer != sortedPartSums[answer - 1]) {
            println(answer)
            return
        }

        answer++
    }
}

private fun search(idx: Int, s: List<Int>, sum: Int, n: Int) {
    for (i in idx + 1 until n) {
        partSums.add(sum + s[i])
        search(i, s, sum + s[i], n)
    }
}
