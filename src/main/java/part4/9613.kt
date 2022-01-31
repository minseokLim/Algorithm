package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val answer = StringBuilder()

    for (i in 1..t) {
        val input = br.readLine().split(" ").map { it.toInt() }
        var tmp: Long = 0

        for (j in 1 until input.size - 1) {
            for (k in (j + 1) until input.size) {
                tmp += getGcd(input[j], input[k])
            }
        }

        answer.append("$tmp\n")
    }

    println(answer)
}

private fun getGcd(a: Int, b: Int): Int {
    if (b > a) return getGcd(b, a)

    if (a % b == 0) return b

    return getGcd(b, a % b)
}
