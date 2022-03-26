package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ")
    val a = input[0].toInt()
    val b = input[1].toInt()
    val gcd = getGcd(a, b)
    val lcm = a * b / gcd

    println("$gcd\n$lcm")
}

private fun getGcd(a: Int, b: Int): Int {
    if (a < b) return getGcd(b, a)

    if (a % b == 0) return b

    return getGcd(b, a % b)
}
