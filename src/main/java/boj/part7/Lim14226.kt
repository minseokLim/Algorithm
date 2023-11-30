package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val visited = Array(2001) { BooleanArray(2001) }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().toInt()

    class Emoticon(
        val count: Int,
        val time: Int,
        val clipboard: Int = 0
    ) {
        fun getNexts(): Set<Emoticon> {
            val result = mutableSetOf<Emoticon>()
            val nextTime = time + 1

            if (count + clipboard < 2000 && !visited[count + clipboard][clipboard]) {
                result.add(Emoticon(count + clipboard, nextTime, clipboard))
                visited[count + clipboard][clipboard] = true
            }
            if (!visited[count][count]) {
                result.add(Emoticon(count, nextTime, count))
                visited[count][count] = true
            }
            if (count - 1 > 0 && !visited[count - 1][clipboard]) {
                result.add(Emoticon(count - 1, nextTime, clipboard))
                visited[count - 1][clipboard] = true
            }

            return result
        }
    }

    val queue: Queue<Emoticon> = LinkedList()
    queue.offer(Emoticon(1, 0))
    visited[1][0] = true

    while (queue.isNotEmpty()) {
        val polled = queue.poll()
        if (polled.count == s) {
            println(polled.time)
            return
        }

        queue.addAll(polled.getNexts())
    }
}
