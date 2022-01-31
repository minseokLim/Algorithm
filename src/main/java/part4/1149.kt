package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val minArr = Array(3) { IntArray(n + 1) }
    val init = br.readLine().split(" ").map { it.toInt() }
    minArr[0][1] = init[0]
    minArr[1][1] = init[1]
    minArr[2][1] = init[2]

    for (i in 2..n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        minArr[0][i] = input[0] + min(minArr[1][i - 1], minArr[2][i - 1])
        minArr[1][i] = input[1] + min(minArr[0][i - 1], minArr[2][i - 1])
        minArr[2][i] = input[2] + min(minArr[0][i - 1], minArr[1][i - 1])
    }

    println(min(min(minArr[0][n], minArr[1][n]), minArr[2][n]))
}
