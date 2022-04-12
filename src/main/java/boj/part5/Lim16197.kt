package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private var min = 11
private val directions = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { CharArray(m) }
    val coinPositions = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        board[i] = br.readLine().toCharArray()
        for (j in 0 until m) {
            if (board[i][j] == 'o') {
                coinPositions.add(i to j)
            }
        }
    }

    directions.forEach {
        dfs(board, it, coinPositions, n, m, 1)
    }

    if (min == 11) {
        println(-1)
    } else {
        println(min)
    }
}

private fun dfs(
    board: Array<CharArray>,
    direction: Pair<Int, Int>,
    coinPositions: List<Pair<Int, Int>>,
    n: Int,
    m: Int,
    count: Int
) {
    if (count >= min || count > 10) {
        return
    }

    val outOfRange = coinPositions.map { it + direction }.count { it.outOfRange(n, m) }
    if (outOfRange > 0) {
        if (outOfRange == 1 && count < min) {
            min = count
        }
        return
    }

    val nextPositions = coinPositions.map {
        if (board.get(it + direction) != '#') {
            it + direction
        } else {
            it
        }
    }

    if (nextPositions == coinPositions) {
        return
    }

    directions.forEach {
        dfs(board, it, nextPositions, n, m, count + 1)
    }
}

private operator fun Pair<Int, Int>.plus(target: Pair<Int, Int>): Pair<Int, Int> {
    return this.first + target.first to this.second + target.second
}

private fun Array<CharArray>.get(target: Pair<Int, Int>): Char {
    return this[target.first][target.second]
}

private fun Pair<Int, Int>.outOfRange(n: Int, m: Int): Boolean {
    return (this.first in 0 until n && this.second in 0 until m).not()
}
