package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val count = IntArray(n + 1)

    for (i in 2..n) {
        var min = count[i - 1] + 1

        if (i % 3 == 0 && count[i / 3] + 1 < min) {
            min = count[i / 3] + 1
        }

        if (i % 2 == 0 && count[i / 2] + 1 < min) {
            min = count[i / 2] + 1
        }

        count[i] = min
    }

    println(count[n])
}
