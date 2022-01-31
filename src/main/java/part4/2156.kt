package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    if (n >= 3) {
        val wines = IntArray(n) { br.readLine().toInt() }
        val maxes = Array(n) { IntArray(2) }
        maxes[0][0] = wines[0]
        maxes[0][1] = wines[0]
        maxes[1][0] = wines[1]
        maxes[1][1] = wines[1] + wines[0]
        maxes[2][0] = wines[2] + wines[0]
        maxes[2][1] = wines[2] + wines[1]

        for (i in 3 until n) {
            maxes[i][0] = max(maxes[i - 2].maxOrNull()!!, maxes[i - 3].maxOrNull()!!) + wines[i]
            maxes[i][1] = maxes[i - 1][0] + wines[i]
        }

        println(max(maxes[n - 1].maxOrNull()!!, maxes[n - 2].maxOrNull()!!))
    } else {
        println((1..n).map { br.readLine().toInt() }.sum())
    }
}
