package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()

    val result = StringBuilder()

    var i = 0

    while (i < input.length) {
        if (input[i] == '<') {
            while (input[i] != '>') {
                result.append(input[i++])
            }
            result.append(input[i++])
        } else if (input[i] != ' ') {
            val start = i

            while (++i < input.length && input[i] != ' ' && input[i] != '<') {
                // do nothing
            }

            result.append(input.substring(start, i).reversed())
        } else {
            result.append(input[i++])
        }
    }

    println(result)
}
