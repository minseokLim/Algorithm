package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    var arr = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            arr[i][j] = input[j]
        }
    }

    br.readLine()
        .split(" ")
        .map { it.toInt() }
        .forEach {
            arr = operate(it, arr)
        }

    println(toString(arr))
}

private fun operate(idx: Int, arr: Array<IntArray>): Array<IntArray> {
    return when (idx) {
        1 -> operate1(arr)
        2 -> operate2(arr)
        3 -> operate3(arr)
        4 -> operate4(arr)
        5 -> operate5(arr)
        6 -> operate6(arr)
        else -> throw IllegalArgumentException()
    }
}

private fun operate1(arr: Array<IntArray>): Array<IntArray> {
    val n = arr.size
    val m = arr[0].size
    val next = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            next[i][j] = arr[n - 1 - i][j]
        }
    }
    return next
}

private fun operate2(arr: Array<IntArray>): Array<IntArray> {
    val n = arr.size
    val m = arr[0].size
    val next = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            next[i][j] = arr[i][m - 1 - j]
        }
    }
    return next
}

private fun operate3(arr: Array<IntArray>): Array<IntArray> {
    val n = arr.size
    val m = arr[0].size
    val next = Array(m) { IntArray(n) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            next[j][n - i - 1] = arr[i][j]
        }
    }
    return next
}

private fun operate4(arr: Array<IntArray>): Array<IntArray> {
    val n = arr.size
    val m = arr[0].size
    val next = Array(m) { IntArray(n) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            next[m - j - 1][i] = arr[i][j]
        }
    }
    return next
}

private fun operate5(arr: Array<IntArray>): Array<IntArray> {
    val n = arr.size
    val m = arr[0].size
    val next = Array(n) { IntArray(m) }

    for (i in 0 until n / 2) {
        for (j in 0 until m / 2) {
            next[i][j] = arr[i + n / 2][j]
            next[i][j + m / 2] = arr[i][j]
            next[i + n / 2][j + m / 2] = arr[i][j + m / 2]
            next[i + n / 2][j] = arr[i + n / 2][j + m / 2]
        }
    }

    return next
}

private fun operate6(arr: Array<IntArray>): Array<IntArray> {
    val n = arr.size
    val m = arr[0].size
    val next = Array(n) { IntArray(m) }

    for (i in 0 until n / 2) {
        for (j in 0 until m / 2) {
            next[i][j] = arr[i][j + m / 2]
            next[i + n / 2][j] = arr[i][j]
            next[i + n / 2][j + m / 2] = arr[i + n / 2][j]
            next[i][j + m / 2] = arr[i + n / 2][j + m / 2]
        }
    }

    return next
}

private fun toString(arr: Array<IntArray>): String {
    val answer = StringJoiner(System.lineSeparator())

    arr.forEach {
        answer.add(it.joinToString(" "))
    }
    return answer.toString()
}
