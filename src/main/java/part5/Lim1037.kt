package part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val aliquots = br.readLine().split(" ").map { it.toInt() }
    val min = aliquots.minOrNull()!!
    val max = aliquots.maxOrNull()!!

    println(min * max)
}
