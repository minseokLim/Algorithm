package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val prices = br.readLine().split(" ").map { it.toInt() }
    val maxes = IntArray(n + 1)
    maxes[1] = prices[0]

    for (i in 2..n) {
        var max = prices[i - 1]

        for (j in 1..i/2) {
            if (max < maxes[j] + maxes[i - j]) {
                max = maxes[j] + maxes[i - j]
            }
        }

        maxes[i] = max
    }

    println(maxes[n])
}
