package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(200_000)

    class Subin(
        val x: Int,
        val time: Int
    ) {
        fun getNexts(): Set<Subin> {
            val result = mutableSetOf<Subin>()

            if (x - 1 >= 0 && !visited[x - 1]) {
                result.add(Subin(x - 1, time + 1))
                visited[x - 1] = true
            }
            if (x + 1 <= k && !visited[x + 1]) {
                result.add(Subin(x + 1, time + 1))
                visited[x + 1] = true
            }
            if (x * 2 != 0 && x * 2 < k * 2 && !visited[x * 2]) {
                result.add(Subin(x * 2, time + 1))
                visited[x * 2] = true
            }

            return result
        }
    }

    val queue: Queue<Subin> = LinkedList()
    queue.offer(Subin(n, 0))
    visited[n] = true

    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        if (polled.x == k) {
            println(polled.time)
            return
        }

        queue.addAll(polled.getNexts())
    }
}
