package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c, x, y) = br.readLine().split(" ").map { it.toInt() }
    var min = Int.MAX_VALUE

    for (i in 0..max(x, y)) {
        val price = 2 * c * i + a * (x - i).coerceAtLeast(0) + b * (y - i).coerceAtLeast(0)
        if (price < min) {
            min = price
        }
    }

    println(min)
}
