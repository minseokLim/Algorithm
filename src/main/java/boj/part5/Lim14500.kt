package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private val blocks = listOf(
    Block(0 to 0, 0 to 1, 0 to 2, 0 to 3),
    Block(0 to 0, 1 to 0, 2 to 0, 3 to 0),
    Block(0 to 0, 0 to 1, 1 to 0, 1 to 1),
    Block(0 to 0, 1 to 0, 2 to 0, 2 to 1),
    Block(1 to 0, 1 to 1, 1 to 2, 0 to 2),
    Block(0 to 0, 0 to 1, 1 to 1, 2 to 1),
    Block(0 to 0, 0 to 1, 0 to 2, 1 to 0),
    Block(0 to 1, 1 to 1, 2 to 0, 2 to 1),
    Block(0 to 0, 0 to 1, 0 to 2, 1 to 2),
    Block(0 to 0, 0 to 1, 1 to 0, 2 to 0),
    Block(0 to 0, 1 to 0, 1 to 1, 1 to 2),
    Block(0 to 0, 1 to 0, 1 to 1, 2 to 1),
    Block(1 to 0, 1 to 1, 0 to 1, 0 to 2),
    Block(0 to 1, 1 to 0, 1 to 1, 2 to 0),
    Block(0 to 0, 0 to 1, 1 to 1, 1 to 2),
    Block(0 to 0, 0 to 1, 0 to 2, 1 to 1),
    Block(0 to 1, 1 to 0, 1 to 1, 2 to 1),
    Block(0 to 1, 1 to 0, 1 to 1, 1 to 2),
    Block(0 to 0, 1 to 0, 1 to 1, 2 to 0)
)
private var max = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val scoreTable = arrayOfNulls<IntArray>(n)

    for (i in 0 until n) {
        scoreTable[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            blocks.forEach {
                val score = it.points.map { point ->
                    if (i + point.i >= n || j + point.j >= m) {
                        return@forEach
                    }

                    scoreTable[i + point.i]!![j + point.j]
                }.sum()

                if (score > max) {
                    max = score
                }
            }
        }
    }

    println(max)
}

class Block(
    vararg pairs: Pair<Int, Int>
) {
    val points = pairs.map { Point(it.first, it.second) }
}

class Point(
    val i: Int,
    val j: Int
)
