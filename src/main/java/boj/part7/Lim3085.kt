package boj.part7

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val board = Array(n) { CharArray(n) }
    repeat(n) {
        board[it] = br.readLine().toCharArray()
    }

    var max = 0
    for (i in 0 until n) {
        for (j in 0 until n - 1) {
            swapHorizontal(board, i, j)
            val result = searchMax(board, n)
            if (result > max) {
                max = result
            }
            swapHorizontal(board, i, j)
        }
    }

    for (i in 0 until n - 1) {
        for (j in 0 until n) {
            swapVertical(board, i, j)
            val result = searchMax(board, n)
            if (result > max) {
                max = result
            }
            swapVertical(board, i, j)
        }
    }

    println(max)
}

private fun swapHorizontal(board: Array<CharArray>, i: Int, j: Int) {
    val temp = board[i][j]
    board[i][j] = board[i][j + 1]
    board[i][j + 1] = temp
}

private fun swapVertical(board: Array<CharArray>, i: Int, j: Int) {
    val temp = board[i][j]
    board[i][j] = board[i + 1][j]
    board[i + 1][j] = temp
}

private fun searchMax(board: Array<CharArray>, n: Int): Int {
    var max = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            val hResult = searchHorizontal(board, n, i, j)
            val vResult = searchVertical(board, n, i, j)
            max = maxOf(hResult, vResult, max)
        }
    }

    return max
}

private fun searchHorizontal(board: Array<CharArray>, n: Int, i: Int, j: Int): Int {
    var result = 1

    for (k in j + 1 until n) {
        if (board[i][j] != board[i][k]) {
            break
        }
        result++
    }

    return result
}

private fun searchVertical(board: Array<CharArray>, n: Int, i: Int, j: Int): Int {
    var result = 1

    for (k in i + 1 until n) {
        if (board[i][j] != board[k][j]) {
            break
        }
        result++
    }

    return result
}
