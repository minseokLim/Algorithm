package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val inputList = mutableListOf<Int>()

    for (i in 1..t) {
        val n = br.readLine().toInt()
        inputList.add(n)
    }

    val max = inputList.maxOrNull()!!
    val isPrime = Array(max + 1) { true }

    for (i in 2..sqrt(max.toDouble()).toInt()) {
        if (!isPrime[i]) continue

        for (j in i * 2..max step i) {
            isPrime[j] = false
        }
    }

    val answer = StringBuilder()

    inputList.forEach {
        var count = 0

        for (i in 2..it / 2) {
            if (isPrime[i] && isPrime[it - i]) count++
        }

        answer.append("$count\n")
    }

    println(answer)
}
