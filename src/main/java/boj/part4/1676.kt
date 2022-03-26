package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var twoCount = 0
    var fiveCount = 0

    for (i in 2..n) {
        var tmp = i

        while (tmp % 2 == 0) {
            twoCount++
            tmp /= 2
        }

        while (tmp % 5 == 0) {
            fiveCount++
            tmp /= 5
        }
    }

    println(min(twoCount, fiveCount))
}
