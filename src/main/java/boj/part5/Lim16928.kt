package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val road = (0..100).toMutableList()

    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        road[x] = y
    }
    repeat(m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        road[u] = v
    }

    val visited = BooleanArray(101)

    class Player(
        val position: Int,
        val diceTimes: Int
    ) {
        fun getNextPlayers(): List<Player> {
            return (1..6)
                .filter { position + it in 1..100 && visited[position + it].not() }
                .map {
                    visited[position + it] = true
                    Player(road[position + it], diceTimes + 1)
                }
        }
    }

    val queue: Queue<Player> = LinkedList()
    val initials = (2..7).map {
        visited[road[it]] = true
        Player(road[it], 1)
    }
    queue.addAll(initials)

    while (queue.isNotEmpty()) {
        val polled = queue.poll()

        if (polled.position == 100) {
            println(polled.diceTimes)
            return
        }

        val nextPlayers = polled.getNextPlayers()
        queue.addAll(nextPlayers)
    }
}
