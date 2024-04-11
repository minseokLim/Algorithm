package programmers.part1

import kotlin.math.min

class Lim72413 {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val minFares = Array(n + 1) { IntArray(n + 1) }
        for (i in 1..n) {
            for (j in 1..n) {
                if (i != j) {
                    // n = 200, f = 100,000 -> 200 * 100,000
                    minFares[i][j] = 20_000_000
                }
            }
        }

        fares.forEach {
            minFares[it[0]][it[1]] = it[2]
            minFares[it[1]][it[0]] = it[2]
        }

        for (k in 1..n) {
            for (i in 1..n) {
                for (j in i + 1..n) {
                    minFares[i][j] = min(minFares[i][j], minFares[i][k] + minFares[k][j])
                    minFares[j][i] = minFares[i][j]
                }
            }
        }

        var answer = minFares[s][a] + minFares[s][b]
        for (i in 1..n) {
            if (i != s) {
                answer = min(answer, minFares[s][i] + minFares[i][a] + minFares[i][b])
            }
        }

        return answer
    }
}
