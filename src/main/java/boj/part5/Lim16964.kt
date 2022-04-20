package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

var currentIdx = 0
val connected = mutableMapOf<Int, MutableList<Int>>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        connected.putIfAbsent(a, mutableListOf())
        connected.putIfAbsent(b, mutableListOf())
        connected[a]!!.add(b)
        connected[b]!!.add(a)
    }

    val visitingDots = br.readLine().split(" ").map { it.toInt() }
    val indexOfDots = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        indexOfDots[visitingDots[i]] = i
    }

    connected.forEach { entry ->
        entry.value.sortBy { indexOfDots[it] }
    }

    val visited = BooleanArray(n + 1)
    val result = dfs(1, visitingDots, visited)

    if (result) {
        println(1)
    } else {
        println(0)
    }
}

private fun dfs(i: Int, visitingDots: List<Int>, visited: BooleanArray): Boolean {
    visited[i] = true

    if (visitingDots[currentIdx] != i) {
        return false
    }

    connected[i]!!.forEach {
        if (!visited[it]) {
            currentIdx++
            val result = dfs(it, visitingDots, visited)
            if (result.not()) {
                return false
            }
        }
    }

    return true
}
