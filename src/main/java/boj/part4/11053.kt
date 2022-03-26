package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

// TODO 백준 내 소스에 다른 풀이 한 번 보자
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }

    val maxes = IntArray(n) { 1 }

    for (i in (n - 2) downTo 0) {
        var max = 1

        for (j in (i + 1) until n) {
            if (seq[i] < seq[j] && max < maxes[j] + 1) {
                max = maxes[j] + 1
            }
        }

        maxes[i] = max
    }

    println(maxes.maxOrNull()!!)
}
