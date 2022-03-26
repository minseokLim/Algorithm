package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ")
    val n = input[0].toInt()
    val k = input[1].toInt()
    val list = (1..n).toMutableList()

    var i = 0
    val result = mutableListOf<Int>()

    while(list.isNotEmpty()) {
        i = (i + k - 1) % list.size
        result.add(list[i])
        list.removeAt(i)
    }

    println(result.joinToString(separator = ", ", prefix = "<", postfix = ">"))
}
