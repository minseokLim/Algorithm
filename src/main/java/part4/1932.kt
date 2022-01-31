package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val input = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    var a = IntArray(1) { input[0][0] }

    for (i in 1 until n) {
        val b = IntArray(i + 1)
        b[0] = a[0] + input[i][0]
        b[i] = a[i - 1] + input[i][i]

        for (j in 1 until i) {
            b[j] = max(a[j - 1], a[j]) + input[i][j]
        }

        a = b
    }

    println(a.maxOrNull()!!)
}
