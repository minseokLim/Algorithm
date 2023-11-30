package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (e, s, m) = br.readLine().split(" ").map { it.toInt() }

    var i = 1
    while (true) {
        if (e == (i - 1) % 15 + 1 && s == (i - 1) % 28 + 1 && m == (i - 1) % 19 + 1) {
            println(i)
            break
        }
        i++
    }
}
