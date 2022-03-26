package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val prices = br.readLine().split(" ").map { it.toInt() }
    val mins = IntArray(n + 1)
    mins[1] = prices[0]

    for (i in 2..n) {
        var min = prices[i - 1]

        for (j in 1..i/2) {
            if (min > mins[j] + mins[i - j]) {
                min = mins[j] + mins[i - j]
            }
        }

        mins[i] = min
    }

    println(mins[n])
}
