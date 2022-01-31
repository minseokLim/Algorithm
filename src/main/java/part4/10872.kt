package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    if (n == 0) {
        println(1)
        return
    }

    println((1..n).reduce { a, b -> a * b })
}
