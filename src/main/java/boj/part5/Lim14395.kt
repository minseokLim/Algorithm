package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (s, t) = br.readLine().split(" ").map { it.toLong() }
    val visited = mutableSetOf<Long>()

    if (s == t) {
        println(0)
        return
    }

    class Operations(
        val value: Long,
        val operations: String
    ) {
        fun setQueue(queue: Queue<Operations>) {
            if (value * value <= t && !visited.contains(value * value)) {
                visited.add(value * value)
                queue.add(Operations(value * value, "$operations*"))
            }
            if (value + value <= t && !visited.contains(value + value)) {
                visited.add(value + value)
                queue.add(Operations(value + value, "$operations+"))
            }
            if (!visited.contains(0)) {
                visited.add(0)
                queue.add(Operations(0, "$operations-"))
            }
            if (value != 0L && !visited.contains(1)) {
                visited.add(1)
                queue.add(Operations(1, "$operations/"))
            }
        }
    }

    val first = Operations(s, "")
    val queue: Queue<Operations> = LinkedList()
    queue.offer(first)

    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled.value == t) {
            println(polled.operations)
            return
        }

        polled.setQueue(queue)
    }

    println(-1)
}
