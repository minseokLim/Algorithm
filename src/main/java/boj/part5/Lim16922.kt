package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val numbers = mutableSetOf<Int>()
    for (i in 0 .. n) {
        for (j in 0..n - i) {
            for (k in 0..n - i - j) {
                val number = 1 * i + 5 * j + 10 * k + 50 * (n - i - j - k)
                numbers.add(number)
            }
        }
    }

    println(numbers.size)
}
