package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val inputs = mutableListOf<Int>()

    for (i in 1..t) {
        inputs.add(br.readLine().toInt())
    }

    val count1 = LongArray(100001)
    val count2 = LongArray(100001)
    val count3 = LongArray(100001)

    count1[1] = 1L
    count2[2] = 1L
    count1[3] = 1L
    count2[3] = 1L
    count3[3] = 1L

    for (i in 4..inputs.maxOrNull()!!) {
        count1[i] = (count2[i - 1] + count3[i - 1]) % 1_000_000_009
        count2[i] = (count1[i - 2] + count3[i - 2]) % 1_000_000_009
        count3[i] = (count1[i - 3] + count2[i - 3]) % 1_000_000_009
    }

    println(inputs.map { (count1[it] + count2[it] + count3[it])  % 1_000_000_009 }.joinToString("\n"))
}
