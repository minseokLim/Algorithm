package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val answer = StringBuilder()
    var s = 0
    var e = if (input.length % 3 == 0) 3 else input.length % 3

    while (e <= input.length) {
        answer.append(solve(input.substring(s, e)))
        s = e
        e = s + 3
    }

    println(answer)
}

fun solve(str: String): Int {
    var result = 0

    str.forEach {
        result = 2 * result + it.toParsedInt()
    }

    return result
}

fun Char.toParsedInt() = toString().toInt()
