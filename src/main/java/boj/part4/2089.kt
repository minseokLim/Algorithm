package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    if (n == 0) {
        println(0)
        return
    }

    println(solve(n))
}

fun solve(n: Int): String {
    var x = n
    val result = StringBuilder()

    while (x != 0) {
        var r = x % -2

        if (r < 0) {
            r += 2
            x = (x - 2) / -2
        } else {
            x /= -2
        }

        result.append(r)
    }

    return result.reverse().toString()
}
