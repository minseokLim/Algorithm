package part5

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

    var next = Array(n) { IntArray(m) }

    repeat(r) {
        var left = 0
        var right = m - 1
        var top = 0
        var bottom = n - 1

        while (right - left > 0 && bottom - top > 0) {
            for (i in top + 1..bottom) {
                next[i][left] = arr[i - 1][left]
            }
            for (i in left + 1..right) {
                next[bottom][i] = arr[bottom][i - 1]
            }
            for (i in top until bottom) {
                next[i][right] = arr[i + 1][right]
            }
            for (i in left until right) {
                next[top][i] = arr[top][i + 1]
            }
            left++
            right--
            top++
            bottom--
        }

        val tmp = next
        next = arr
        arr = tmp
    }

    println(toString(arr))
}

private fun toString(arr: Array<IntArray>): String {
    val answer = StringJoiner(System.lineSeparator())

    arr.forEach {
        answer.add(it.joinToString(" "))
    }
    return answer.toString()
}
