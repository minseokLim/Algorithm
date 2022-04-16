package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private const val INF = Int.MAX_VALUE - 15000000
private var n = 0
private lateinit var w: Array<IntArray>
private lateinit var dpWeightToEnd: Array<IntArray>
private lateinit var dpEndPoint: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    w = Array(n) { IntArray(n) }
    dpWeightToEnd = Array(n) { IntArray(1.shl(n)) }
    dpEndPoint = Array(n) { IntArray(1.shl(n)) }

    for (i in 0 until n) {
        w[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var min = Int.MAX_VALUE
    for (i in 0 until n) {
        val tpsValue = tps(i, 1.shl(i))
        val weight = tpsValue.first
        val endWeight = w[tpsValue.second][i]

        if (endWeight != 0) {
            min = min(min, weight + endWeight)
        }
    }

    println(min)
}

private fun tps(current: Int, visited: Int): Pair<Int, Int> {
    if (1.shl(n) - 1 == visited) {
        return 0 to current
    }

    if (dpWeightToEnd[current][visited] != 0) {
        return dpWeightToEnd[current][visited] to dpEndPoint[current][visited]
    }

    dpWeightToEnd[current][visited] = INF
    for (i in 0 until n) {
        val next = 1.shl(i)

        if (next.and(visited) == 0 && w[current][i] != 0) {
            val tpsValue = tps(i, next.or(visited))

            if (dpWeightToEnd[current][visited] > tpsValue.first + w[current][i]) {
                dpWeightToEnd[current][visited] = tpsValue.first + w[current][i]
                dpEndPoint[current][visited] = tpsValue.second
            }
        }
    }

    return dpWeightToEnd[current][visited] to dpEndPoint[current][visited]
}
