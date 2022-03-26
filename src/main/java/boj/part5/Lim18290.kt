package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private var n = 0
private var m = 0
private var k = 0
private lateinit var spots: MutableList<Spot>
private var max = Int.MIN_VALUE
private val picked = mutableSetOf<Spot>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val firstInputs = br.readLine().split(" ").map { it.toInt() }
    n = firstInputs[0]
    m = firstInputs[1]
    k = firstInputs[2]
    spots = mutableListOf()

    for (i in 0 until n) {
        br.readLine().split(" ").forEachIndexed { j, s ->
            spots.add(Spot(i, j, s.toInt()))
        }
    }

    for (i in 0 until n * m) {
        picked.add(spots[i])
        solve(i, 1)
        picked.remove(spots[i])
    }

    println(max)
}

private fun solve(idx: Int, depth: Int) {
    if (depth == k) {
        val score = picked.sumOf { it.score }
        if (score > max) {
            max = score
        }

        return
    }

    for (i in idx + 1 until n * m) {
        if (picked.any { it.isClose(spots[i]) }) {
            continue
        }

        picked.add(spots[i])
        solve(i, depth + 1)
        picked.remove(spots[i])
    }
}

class Spot(
    private val i: Int,
    private val j: Int,
    val score: Int
) {
    fun isClose(other: Spot): Boolean {
        return i == other.i - 1 && j == other.j || i == other.i + 1 && j == other.j || i == other.i && j == other.j - 1 || i == other.i && j == other.j + 1
    }
}
