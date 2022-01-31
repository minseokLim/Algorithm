package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    fun max(vararg numbers: Int): Int {
        return numbers.maxOrNull()!!
    }

    if (n >= 3) {
        val wines = IntArray(n) { br.readLine().toInt() }
        val maxes = IntArray(n)

        maxes[0] = wines[0]
        maxes[1] = wines[0] + wines[1]
        maxes[2] = max(wines[0] + wines[1], wines[0] + wines[2], wines[1] + wines[2])

        for (i in 3 until n) {
            maxes[i] = max(maxes[i - 1], maxes[i - 2] + wines[i], maxes[i - 3] + wines[i - 1] + wines[i])
        }

        println(maxes[n - 1])
    } else {
        println((1..n).map { br.readLine().toInt() }.sum())
    }
}
