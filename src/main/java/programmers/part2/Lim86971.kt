package programmers.part2

import kotlin.math.abs

class Lim86971 {
    private var answer = Int.MAX_VALUE

    fun solution(n: Int, wires: Array<IntArray>): Int {
        val connected = Array(n) { BooleanArray(n) }
        wires.forEach {
            connected[it[0] - 1][it[1] - 1] = true
            connected[it[1] - 1][it[0] - 1] = true
        }
        wires.forEach {
            connected[it[0] - 1][it[1] - 1] = false
            connected[it[1] - 1][it[0] - 1] = false

            val visited = BooleanArray(n)
            solve(0, connected, visited)
            val visitedCount = visited.count { it }
            val gap = abs(n - visitedCount - visitedCount)

            if (gap < answer) {
                answer = gap
            }

            connected[it[0] - 1][it[1] - 1] = true
            connected[it[1] - 1][it[0] - 1] = true
        }

        return answer
    }

    private fun solve(idx: Int, connected: Array<BooleanArray>, visited: BooleanArray) {
        visited[idx] = true

        for (i in connected.indices) {
            if (visited[i].not() && connected[idx][i]) {
                solve(i, connected, visited)
            }
        }
    }
}
