package part5

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, l) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until n) {
            map[i][j] = input[j]
        }
    }

    var answer = 0

    for (i in 0 until n) {
        var before = map[i][0]
        val occupied = BooleanArray(n)
        var road = true
        outer@ for (j in 1 until n) {
            if (map[i][j] == before) {
                before = map[i][j]
                continue
            } else if (abs(before - map[i][j]) > 1) {
                road = false
                break@outer
            } else if (map[i][j] - before == 1) {
                if (j - l < 0) {
                    road = false
                    break@outer
                }
                for (k in 1 .. l) {
                    if (occupied[j - k]) {
                        road = false
                        break@outer
                    }
                }
                for (k in 1 .. l) {
                    occupied[j - k] = true
                    if (map[i][j - k] != map[i][j - 1]) {
                        road = false
                        break@outer
                    }
                }
                before = map[i][j]
            } else if (before - map[i][j] == 1) {
                if (j + l > n) {
                    road = false
                    break@outer
                }
                for (k in 0 until l) {
                    if (occupied[j + k]) {
                        road = false
                        break@outer
                    }
                }
                for (k in 0 until l) {
                    occupied[j + k] = true
                    if (map[i][j + k] != map[i][j]) {
                        road = false
                        break@outer
                    }
                }
                before = map[i][j]
            } else {
                road = false
                break@outer
            }
        }

        if (road) {
            answer++
        }
    }

    for (j in 0 until n) {
        var before = map[0][j]
        val occupied = BooleanArray(n)
        var road = true
        outer@ for (i in 1 until n) {
            if (map[i][j] == before) {
                before = map[i][j]
                continue
            } else if (abs(before - map[i][j]) > 1) {
                road = false
                break@outer
            } else if (map[i][j] - before == 1) {
                if (i - l < 0) {
                    road = false
                    break@outer
                }
                for (k in 1 .. l) {
                    if (occupied[i - k]) {
                        road = false
                        break@outer
                    }
                }
                for (k in 1 .. l) {
                    occupied[i - k] = true
                    if (map[i - k][j] != map[i - 1][j]) {
                        road = false
                        break@outer
                    }
                }
                before = map[i][j]
            } else if (before - map[i][j] == 1) {
                if (i + l > n) {
                    road = false
                    break@outer
                }
                for (k in 0 until l) {
                    if (occupied[i + k]) {
                        road = false
                        break@outer
                    }
                }
                for (k in 0 until l) {
                    occupied[i + k] = true
                    if (map[i + k][j] != map[i][j]) {
                        road = false
                        break@outer
                    }
                }
                before = map[i][j]
            } else {
                road = false
                break@outer
            }
        }

        if (road) {
            answer++
        }
    }


    println(answer)
}
