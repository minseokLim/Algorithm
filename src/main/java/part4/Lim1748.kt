package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    println(calculate(n))
}

fun calculate(n: Int): Int {
    if (n < 10) {
        return n
    }

    val nLength = n.toString().length
    val boundary = 10.pow(nLength - 1) - 1
    var result = (n - boundary) * nLength

    if (boundary > 0) {
        result += calculate(boundary)
    }

    return result
}

private fun Int.pow(n: Int): Int {
    var result = 1

    repeat(n) {
        result *= this
    }
    return result
}
