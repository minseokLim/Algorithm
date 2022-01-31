package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var counts = Array(3) { IntArray(n + 1) }
    counts[0][1] = 1
    counts[1][1] = 1
    counts[2][1] = 1

    for (i in 2..n) {
        counts[0][i] = (counts[0][i - 1] + counts[1][i - 1] + counts[2][i - 1]) % 9901
        counts[1][i] = (counts[0][i - 1] + counts[2][i - 1]) % 9901
        counts[2][i] = (counts[0][i - 1] + counts[1][i - 1]) % 9901
    }

    println((counts[0][n] + counts[1][n] + counts[2][n]) % 9901)
}
