package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    if (n > 1) {
        val counts = LongArray(n + 1)
        counts[2] = 3

        for (i in 4..n step 2) {
            counts[i] += counts[i - 2] * 3
            for (j in 4 until i step 2) {
                counts[i] += counts[i - j] * 2
            }

            counts[i] += 2L
        }

        println(counts[n])
    } else {
        println(0)
    }
}
