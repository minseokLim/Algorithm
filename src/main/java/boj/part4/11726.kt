package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    if (n == 1) {
        println(1)
        return
    }

    val count = IntArray(n + 1)
    count[1] = 1
    count[2] = 2

    for (i in 3..n) {
        count[i] = (count[i - 1] + count[i - 2]) % 10007
    }

    println(count[n])
}
