package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    var answer = 0
    var target = 0
    var i = 0

    while (i < input.length) {
        if (input[i] == '(') {
            if(input[i + 1] == ')') {
                answer += target
                i++
            } else {
                target++
            }
        } else {
            answer++
            target--
        }

        i++
    }

    println(answer)
}
