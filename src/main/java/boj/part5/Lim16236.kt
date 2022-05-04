package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val sea = Array(n) { IntArray(n) }

    class BabyShark(
        val i: Int,
        val j: Int,
        var size: Int = 2,
        var eatCount: Int = 0,
        val spentTime: Int = 0
    ) {
        fun getNextSharks(visited: Array<BooleanArray>): List<BabyShark> {
            return listOf(i - 1 to j, i to j - 1, i to j + 1, i + 1 to j)
                .filter { it.first in 0 until n && it.second in 0 until n && !visited[it.first][it.second] && sea[it.first][it.second] <= size }
                .map {
                    visited[it.first][it.second] = true
                    BabyShark(it.first, it.second, size, eatCount, spentTime + 1)
                }
        }

        fun addEatCount() {
            eatCount++

            if (eatCount == size) {
                size++
                eatCount = 0
            }
        }
    }

    var babyShark: BabyShark? = null
    for (i in 0 until n) {
        val input = br.readLine().split(" ")
            .map { it.toInt() }
            .toIntArray()

        for (j in 0 until n) {
            if (input[j] == 9) {
                babyShark = BabyShark(i, j)
                sea[i][j] = 0
            } else {
                sea[i][j] = input[j]
            }
        }
    }

    var answer = 0
    while (babyShark != null) {
        val queue: Queue<BabyShark> = LinkedList()
        queue.offer(babyShark)
        val visited = Array(n) { BooleanArray(n) }
        visited[babyShark.i][babyShark.j] = true

        var minDistance = Int.MAX_VALUE
        val list = mutableListOf<BabyShark>()
        while (queue.isNotEmpty()) {
            val polled = queue.poll()

            if (polled.spentTime > minDistance) {
                break
            }
            if (sea[polled.i][polled.j] != 0 && sea[polled.i][polled.j] < polled.size && polled.spentTime <= minDistance) {
                minDistance = polled.spentTime
                list.add(polled)
            }

            queue.addAll(polled.getNextSharks(visited))
        }

        babyShark = list.sortedBy { it.j }.minByOrNull { it.i }

        if (babyShark != null) {
            babyShark.addEatCount()
            sea[babyShark.i][babyShark.j] = 0
            answer = babyShark.spentTime
        }
    }

    println(answer)
}
