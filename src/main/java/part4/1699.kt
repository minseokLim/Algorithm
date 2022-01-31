package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val minArr = IntArray(n + 1)

    for (i in 1..n) {
        if (i * i > n) break
        minArr[i * i] = 1
    }

    for (i in 1..n) {
        if (minArr[i] != 0) continue
        var min = n

        for (j in sqrt(i.toDouble()).toInt() downTo 1) {
            val temp = i / j.square() + minArr[i % j.square()]
            if (min > temp) min = temp
        }

        minArr[i] = min
    }

    println(minArr[n])

}

fun Int.square() = this * this
