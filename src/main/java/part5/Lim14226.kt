package part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

private val checked = Array(2001) { BooleanArray(2001) }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().toInt()

    val queue = LinkedList<Action>()
    queue.push(Action(1, 0))

    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled.count == s) {
            println(polled.time)
            break
        }

        queue.addAll(polled.getNextActions())
    }
}

private class Action(
    val count: Int,
    val time: Int,
    val clipboard: Int = 0
) {
    init {
        checked[count][clipboard] = true
    }

    fun getNextActions(): List<Action> {
        val result = mutableListOf<Action>()

        if (count != clipboard && checked[count][count].not()) {
            result.add(Action(count, time + 1, count))
        }
        if (clipboard != 0 && count + clipboard <= 2000 && checked[count + clipboard][clipboard].not()) {
            result.add(Action(count + clipboard, time + 1, clipboard))
        }
        if (count - 1 > 0 && checked[count - 1][clipboard].not()) {
            result.add(Action(count - 1, time + 1, clipboard))
        }

        return result
    }
}
