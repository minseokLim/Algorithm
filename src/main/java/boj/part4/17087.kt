package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().split(" ").map { it.toInt() }[1]
    val positions: List<Int> = (br.readLine().split(" ").map { it.toInt() } as MutableList).apply {
        add(s)
        sort()
    }

    fun getGcd(a: Int, b: Int): Int {
        if (b > a) return getGcd(b, a)

        if (a % b == 0) return b

        return getGcd(b, a % b)
    }

    fun getGcd(numbers: List<Int>): Int {
        return numbers.reduce { a, b -> getGcd(a, b) }
    }

    val gapList = mutableListOf<Int>()

    for (i in 0 until positions.size - 1) {
        gapList.add(positions[i + 1] - positions[i])
    }

    println(getGcd(gapList))
}
