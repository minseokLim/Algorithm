package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

val broken = BooleanArray(10)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    if (m > 0) {
        br.readLine().split(" ").map { it.toInt() }.forEach {
            broken[it] = true
        }
    }

    var min = Int.MAX_VALUE
    for (i in 0..1_000_000) {
        if (isPossible(i)) {
            min = minOf(min, i.toString().length + abs(i - n))
        }
    }

    println(minOf(min, abs(n - 100)))
}

private fun isPossible(target: Int): Boolean {
    var temp = target

    while (true) {
        val x = temp % 10
        if (broken[x]) {
            return false
        }
        temp /= 10

        if (temp == 0) {
            break
        }
    }
    return true
}
