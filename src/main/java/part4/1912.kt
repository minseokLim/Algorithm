package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }
    var sum = seq[0]
    var max = sum

    for (i in 1 until n) {
        if (sum > 0) {
            sum += seq[i]
        } else {
            sum = seq[i]
        }

        if (max < sum) max = sum
    }

    println(max)
}
