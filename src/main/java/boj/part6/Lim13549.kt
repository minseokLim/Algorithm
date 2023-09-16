package boj.part6

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    data class Subin(
        val position: Int,
        val elapsedTime: Int
    ) {
        fun getNexts(visited: BooleanArray): List<Subin> {
            val result = mutableListOf<Subin>()

            if (position - 1 >= 0 && visited[position - 1].not()) {
                val before = Subin(position - 1, elapsedTime + 1)
                result.add(before)
                result.addAll(before.getDoubles(visited))
            }
            if (position + 1 <= 100000 && visited[position + 1].not()) {
                val after = Subin(position + 1, elapsedTime + 1)
                result.add(after)
                result.addAll(after.getDoubles(visited))
            }

            result.forEach { visited[it.position] = true }
            return result
        }

        fun getDoubles(visited: BooleanArray): List<Subin> {
            val result = mutableListOf<Subin>()

            if (position != 0 && position * 2 <= 100000 && visited[position * 2].not()) {
                val double = Subin(position * 2, elapsedTime)
                result.add(double)
                result.addAll(double.getDoubles(visited))
            }

            result.forEach { visited[it.position] = true }
            return result
        }
    }

    val visited = BooleanArray(100001)
    val firstSubin = Subin(n, 0)

    val queue = LinkedList<Subin>()
    queue.add(firstSubin)
    visited[firstSubin.position] = true
    queue.addAll(firstSubin.getDoubles(visited))

    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled.position == k) {
            println(polled.elapsedTime)
            return
        }

        queue.addAll(polled.getNexts(visited))
    }
}
