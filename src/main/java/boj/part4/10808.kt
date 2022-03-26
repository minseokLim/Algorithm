package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val answer = IntArray('z' - 'a' + 1)

    for (c in s) {
        answer[c - 'a']++
    }

    println(answer.joinToString(" "))
}
