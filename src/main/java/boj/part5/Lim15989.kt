package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

// TODO : 한 번 더 볼 필요
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val numbers = mutableListOf<Int>()

    repeat(t) {
        numbers.add(br.readLine().toInt())
    }

    val max = numbers.maxOrNull()!!
    val dp = IntArray(max + 1)
    dp[0] = 1

    for (i in 1..3) {
        for (j in i..max) {
            dp[j] += dp[j - i]
        }
    }

    val answer = numbers.joinToString(System.lineSeparator()) { dp[it].toString() }
    println(answer)
}
