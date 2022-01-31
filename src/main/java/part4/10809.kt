package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val answer = IntArray('z' - 'a' + 1)

    for (i in answer.indices) {
        answer[i] = -1
    }

    for ((i, value) in s.withIndex()) {
        if (answer[value - 'a'] == -1) {
            answer[value - 'a'] = i
        }
    }

    println(answer.joinToString(" "))
}
