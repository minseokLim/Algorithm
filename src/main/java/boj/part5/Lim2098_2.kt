package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private const val INF = Int.MAX_VALUE - 15000000
private var n = 0
private lateinit var w: Array<IntArray>
private lateinit var dp: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    w = Array(n) { IntArray(n) }
    dp = Array(n) { IntArray(1.shl(n)) }

    for (i in 0 until n) {
        w[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    // 어차피 순회기 때문에 0에서만 체크해도 상관 없다.
    println(tps(0, 1))
}

// 현재 visited 상태에서 current에서 끝까지 탐색을 진행할 때 최소 비용을 반환한다.
private fun tps(current: Int, visited: Int): Int {
    if (1.shl(n) - 1 == visited) {
        if (w[current][0] == 0) {
            return INF
        }
        return w[current][0]
    }

    if (dp[current][visited] != 0) {
        return dp[current][visited]
    }

    dp[current][visited] = INF
    for (i in 0 until n) {
        val next = 1.shl(i)

        if (next.and(visited) == 0 && w[current][i] != 0) {
            dp[current][visited] = min(dp[current][visited], tps(i, next.or(visited)) + w[current][i])
        }
    }

    return dp[current][visited]
}
