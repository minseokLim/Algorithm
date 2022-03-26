package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 1..t) {
        val n = br.readLine().toInt()
        val input = Array(2) { IntArray(n) }
        input[0] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        input[1] = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        val maxes = Array(3) { IntArray(n) }
        maxes[0][0] = input[0][0]
        maxes[1][0] = input[1][0]
        maxes[2][0] = 0

        for (j in 1 until n) {
            maxes[0][j] = input[0][j] + max(maxes[1][j - 1], maxes[2][j - 1])
            maxes[1][j] = input[1][j] + max(maxes[0][j - 1], maxes[2][j - 1])
            maxes[2][j] = max(maxes[0][j - 1], maxes[1][j - 1])
        }

        println(max(max(maxes[0][n - 1], maxes[1][n - 1]), maxes[2][n - 1]))
    }
}
