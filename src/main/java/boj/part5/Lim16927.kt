package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    val original = Array(n) { IntArray(m) }
    val answer = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            original[i][j] = input[j]
        }
    }

    original.copyAllTo(answer)
    var before = Array(n) { IntArray(m) }
    var next = Array(n) { IntArray(m) }

    var left = 0
    var right = m - 1
    var top = 0
    var bottom = n - 1

    while (right - left > 0 && bottom - top > 0) {
        val rotationTimes = r % (2 * (right - left) + 2 * (bottom - top))

        if (rotationTimes > 0) {
            original.copyBoundary(before, top, bottom, left, right)
            repeat(rotationTimes) {
                for (i in top + 1..bottom) {
                    next[i][left] = before[i - 1][left]
                }
                for (i in left + 1..right) {
                    next[bottom][i] = before[bottom][i - 1]
                }
                for (i in top until bottom) {
                    next[i][right] = before[i + 1][right]
                }
                for (i in left until right) {
                    next[top][i] = before[top][i + 1]
                }
                val tmp = next
                next = before
                before = tmp
            }

            before.copyBoundary(answer, top, bottom, left, right)
        }

        left++
        right--
        top++
        bottom--
    }

    println(toString(answer))
}

private fun toString(arr: Array<IntArray>): String {
    val answer = StringJoiner(System.lineSeparator())

    arr.forEach {
        answer.add(it.joinToString(" "))
    }
    return answer.toString()
}

private fun Array<IntArray>.copyAllTo(dest: Array<IntArray>) {
    this.forEachIndexed { idx, arr ->
        System.arraycopy(arr, 0, dest[idx], 0, arr.size)
    }
}

private fun Array<IntArray>.copyBoundary(dest: Array<IntArray>, top: Int, bottom: Int, left: Int, right: Int) {
    for (i in top + 1..bottom) {
        dest[i][left] = this[i][left]
    }
    for (i in left + 1..right) {
        dest[bottom][i] = this[bottom][i]
    }
    for (i in top until bottom) {
        dest[i][right] = this[i][right]
    }
    for (i in left until right) {
        dest[top][i] = this[top][i]
    }
}
