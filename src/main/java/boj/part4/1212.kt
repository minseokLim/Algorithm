package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()

    if (input == "0") {
        println(0)
        return
    }

    println(input.mapIndexed { i, c ->
        if (i == 0) solve(c) else solve(c, true)
    }.joinToString(""))
}

fun solve(c: Char, pad: Boolean = false): String {
    var n = c.toString().toInt()
    val result = StringBuilder()

    while (n > 0) {
        result.append(n % 2)
        n /= 2
    }

    return if (pad) result.reverse().padStart(3, '0').toString() else result.reverse().toString()
}
