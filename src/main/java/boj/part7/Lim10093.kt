package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toLong() }

    if (a == b) {
        println(0)
    } else {
        val count = abs(a - b) - 1
        val range = if (a < b) a + 1..b - 1 else b + 1..a - 1

        val answer = StringJoiner(" ")
        for (i in range) {
            answer.add(i.toString())
        }

        println(count)
        println(answer)
    }
}
