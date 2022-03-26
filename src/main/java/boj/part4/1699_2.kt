package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val minArr = IntArray(n + 1)
    println(find(n, minArr))
}

fun find(n: Int, minArr: IntArray): Int {
    if (n == 0) return 0
    if (minArr[n] != 0) return minArr[n]

    fun Int.square() = this * this

    var min = n

    for (i in sqrt(n.toDouble()).toInt() downTo 2) {
        val tmp = n / i.square() + find(n % i.square(), minArr)
        if (tmp < min) min = tmp
    }

    minArr[n] = min
    return min
}
