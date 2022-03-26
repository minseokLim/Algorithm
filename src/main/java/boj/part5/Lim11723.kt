package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

private var status = 0
private val answer = StringJoiner(System.lineSeparator())

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val m = br.readLine().toInt()

    repeat(m) {
        solve(br.readLine())
    }

    println(answer)
}

private fun solve(input: String) {
    val inputs = input.split(" ")
    val command = inputs[0]

    if (command == "all" || command == "empty") {
        when (command) {
            "all" -> status = (1 shl 20) - 1
            "empty" -> status = 0
        }
        return
    }

    val number = inputs[1].toInt()

    when (command) {
        "add" -> status = (1 shl (number - 1)).or(status)
        "remove" -> status = (1 shl (number - 1)).inv().and(status)
        "toggle" -> status = (1 shl (number - 1)).xor(status)
        "check" -> {
            if ((1 shl (number - 1)).and(status) == 0) {
                answer.add("0")
            } else {
                answer.add("1")
            }
        }
    }
}
