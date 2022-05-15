package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sticks = mutableListOf<String>()
    val visited = mutableSetOf<String>()

    repeat(3) {
        sticks.add(readStick(br))
    }

    class Game(
        val gameSticks: List<String>,
        val moveCount: Int
    ) {
        fun setQueue(queue: Queue<Game>) {
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    if (i != j && gameSticks[i].isNotEmpty()) {
                        val nextSticks = mutableListOf(*gameSticks.toTypedArray())
                        nextSticks[i] = gameSticks[i].substring(0, gameSticks[i].length - 1)
                        nextSticks[j] = gameSticks[j] + gameSticks[i][gameSticks[i].length - 1]

                        val visitCheck = nextSticks.joinToString("|")
                        if (visited.contains(visitCheck).not()) {
                            queue.offer(Game(nextSticks, moveCount + 1))
                            visited.add(visitCheck)
                        }
                    }
                }
            }
        }

        fun check(): Boolean {
            return gameSticks[0].all { it == 'A' } && gameSticks[1].all { it == 'B' } && gameSticks[2].all { it == 'C' }
        }
    }

    val queue: Queue<Game> = LinkedList()
    queue.offer(Game(sticks, 0))
    visited.add(sticks.joinToString("|"))

    var answer = 0
    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled.check()) {
            answer = polled.moveCount
            break
        }

        polled.setQueue(queue)
    }

    println(answer)
}

private fun readStick(br: BufferedReader): String {
    return br.readLine().split(" ").getOrNull(1) ?: ""
}

