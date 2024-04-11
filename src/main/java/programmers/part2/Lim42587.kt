package programmers.part2

import java.util.LinkedList
import java.util.Queue

class Lim42587 {
    fun solution(priorities: IntArray, location: Int): Int {
        val queue: Queue<Element> = LinkedList(priorities.mapIndexed { idx, priority ->
            Element(idx, priority)
        })
        val executed = mutableListOf<Element>()

        while (queue.isNotEmpty()) {
            val polled = queue.poll()

            if (queue.isNotEmpty() && polled.priority < queue.maxOf { it.priority }) {
                queue.offer(polled)
            } else {
                executed.add(polled)

                if (polled.idx == location) {
                    return executed.size
                }
            }
        }

        return -1
    }

    data class Element(
        val idx: Int,
        val priority: Int
    )
}
