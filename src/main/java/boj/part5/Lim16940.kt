package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    class Dot(
        val value: Int,
        val depth: Int
    )

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val connected = mutableMapOf<Int, MutableSet<Int>>()
    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        connected.putIfAbsent(a, mutableSetOf())
        connected.putIfAbsent(b, mutableSetOf())
        connected[a]!!.add(b)
        connected[b]!!.add(a)
    }

    val visitingDots = br.readLine().split(" ").map { it.toInt() }

    if (visitingDots[0] != 1) {
        println(0)
        return
    }

    val queue: Queue<Dot> = LinkedList()
    queue.offer(Dot(visitingDots[0], 1))
    val visited = BooleanArray(n + 1)
    visited[visitingDots[0]] = true

    val indexOfDots = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        indexOfDots[visitingDots[i]] = i
    }

    val priority = mutableMapOf(visitingDots[0] to 1)

    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        val nextDots = connected[polled.value]!!
            .filter { visited[it].not() }
            .map {
                visited[it] = true
                priority[it] = (polled.depth + 1) * n + indexOfDots[polled.value]!!
                Dot(it, polled.depth + 1)
            }

        queue.addAll(nextDots)
    }

    for (i in 0 until n - 1) {
        if (priority[visitingDots[i]]!! > priority[visitingDots[i + 1]]!!) {
            println(0)
            return
        }
    }

    println(1)
}
