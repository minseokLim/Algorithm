package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val inputs = mutableListOf<String>()
    for (i in 0 until n) {
        inputs.add(br.readLine())
    }

    val characters = inputs.flatMap { it.toList() }.distinct()
    val numbers = (9 downTo 9 - characters.size + 1).toMutableList()

    val scores = mutableMapOf<Char, Int>()
    for (input in inputs) {
        for (i in input.indices) {
            val s = input.length - i - 1
            scores.merge(input[i], 10.power(s)) { before, after -> before + after }
        }
    }

    val charIntMap = scores.entries
        .sortedByDescending { it.value }
        .mapIndexed { idx, entry ->
            entry.key to Character.forDigit(numbers[idx], 10)
        }.toMap()

    val max = inputs.sumOf {
        input -> input.map { charIntMap[it] }.joinToString("").toInt()
    }

    println(max)
}

private fun Int.power(n: Int): Int {
    var result = 1

    repeat(n) {
        result *= this
    }

    return result
}
