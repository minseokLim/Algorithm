package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringJoiner

private const val LIMIT = 200000
private val checked = BooleanArray(LIMIT + 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val queue = LinkedList<Subin>()
    queue.push(Subin(n, 0))

    while (queue.isNotEmpty()) {
        val subin = queue.poll()

        if (subin.position == k) {
            println(subin.time)
            println(subin.getPath())
            break
        }

        queue.addAll(subin.getNextMoves())
    }
}

private class Subin(
    val position: Int,
    val time: Int,
    val before: Subin? = null
) {
    init {
        checked[position] = true
    }

    fun getNextMoves(): List<Subin> {
        val nextTime = time + 1
        val result = mutableListOf<Subin>()

        if (position + 1 <= LIMIT && !checked[position + 1]) {
            result.add(Subin(position + 1, nextTime, this))
        }
        if (position - 1 >= 0 && !checked[position - 1]) {
            result.add(Subin(position - 1, nextTime, this))
        }
        if (position * 2 <= LIMIT && !checked[position * 2]) {
            result.add(Subin(position * 2, nextTime, this))
        }

        return result
    }

    fun getPath(): StringJoiner {
        if (before != null) {
            return before.getPath().add(position.toString())
        }

        return StringJoiner(" ").add(position.toString())
    }
}
