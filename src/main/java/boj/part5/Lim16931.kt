package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val cubes = Array(n) { Array(m) { BooleanArray(100) } }

    for (i in 0 until n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            for (k in 0 until input[j]) {
                cubes[i][j][k] = true
            }
        }
    }

    var answer = 0
    for (i in 0 until n) {
        for (k in 0 until 100) {
            var before = false

            for (j in 0 until m) {
                if (cubes[i][j][k] && before.not()) {
                    answer += 2
                }
                before = cubes[i][j][k]
            }
        }
    }

    for (j in 0 until m) {
        for (k in 0 until 100) {
            var before = false

            for (i in 0 until n) {
                if (cubes[i][j][k] && before.not()) {
                    answer += 2
                }
                before = cubes[i][j][k]
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (cubes[i][j][0]) {
                answer += 2
            }
        }
    }

    println(answer)
}
