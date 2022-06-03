package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val form = br.readLine()

    var multiplier = if (form[0] == 'c') 26 else 10
    var answer = multiplier

    for (i in 1 until form.length) {
        if (form[i] == form[i - 1]) {
            answer *= multiplier - 1
        } else {
            multiplier = if (form[i] == 'c') 26 else 10
            answer *= multiplier
        }
    }

    println(answer)
}
