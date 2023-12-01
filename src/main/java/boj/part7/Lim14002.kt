package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }
    val maxes = Array(n) { mutableListOf(seq[it]) }

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (seq[j] < seq[i] && maxes[j].size + 1 > maxes[i].size) {
                maxes[i] = mutableListOf(seq[i]).apply { this.addAll(maxes[j]) }
            }
        }
    }

    val answer = maxes.maxBy { it.size }.reversed()
    println(answer.size)
    println(answer.joinToString(" "))
}
