package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val rocks = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(125000001)

    val queue: Queue<List<Int>> = LinkedList()
    queue.offer(rocks)
    visited[rocks.toVisited()] = true

    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled.isQualified()) {
            println(1)
            return
        }

        val nextRocks = polled.getNextRocks(visited)
        queue.addAll(nextRocks)
    }

    println(0)
}

private fun List<Int>.toVisited(): Int {
    val sorted = this.sorted()
    val a = sorted[0]
    val b = sorted[1]
    val c = sorted[2]

    return (a - 1) * 500 * 500 + (b - 1) * 500 + (c - 1)
}

private fun List<Int>.getNextRocks(visited: BooleanArray): List<List<Int>> {
    val sorted = this.sorted()
    val a = sorted[0]
    val b = sorted[1]
    val c = sorted[2]

    val nextRocks = listOf(listOf(a * 2, b - a, c), listOf(a * 2, b, c - a), listOf(a, b * 2, c - b))
        .filter { !it.contains(0) && !visited[it.toVisited()] }
    nextRocks.forEach {
        visited[it.toVisited()] = true
    }

    return nextRocks
}

private fun List<Int>.isQualified(): Boolean {
    val first = this[0]

    for (i in 1 until this.size) {
        if (first != this[i]) {
            return false
        }
    }
    return true
}
