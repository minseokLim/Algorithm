package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val count = Array<LongArray>(n + 1) { LongArray(10) }
    count[1] = LongArray(10) { 1 }
    count[1][0] = 0

    for (i in 2..n) {
        count[i][0] = count[i - 1][1]

        for (j in 1..8) {
            count[i][j] = (count[i - 1][j - 1] + count[i - 1][j + 1]) % 1_000_000_000
        }

        count[i][9] = count[i - 1][8]
    }

    println(count[n].sum() % 1_000_000_000)
}
