package part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringJoiner

private fun BufferedReader.readNumbers() = this.readLine().split(" ").map { it.toInt() }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (h, w, x, y) = br.readNumbers()
    val arr = Array(h + x) { IntArray(w + y) }
    val original = Array(h) { IntArray(w) }

    for (i in 0 until h + x) {
        val input = br.readNumbers()
        for (j in 0 until w + y) {
            arr[i][j] = input[j]
        }
    }

    for (i in 0 until x) {
        for (j in 0 until w) {
            original[i][j] = arr[i][j]
        }
    }

    for (i in x until h) {
        for (j in 0 until y) {
            original[i][j] = arr[i][j]
        }
    }

    for (i in h - x until h) {
        for (j in y until w) {
            original[i][j] = arr[i + x][j + y]
        }
    }

    for (i in x until h - x) {
        for (j in w - y until w) {
            original[i][j] = arr[i + x][j + y]
        }
    }

    for (i in x until h - x) {
        for (j in y until w - y) {
            original[i][j] = arr[i][j] - original[i - x][j - y]
        }
    }

    original.print()
}

private fun Array<IntArray>.print() {
    val result = StringJoiner(System.lineSeparator())
    this.forEach {
        result.add(it.joinToString(" "))
    }
    println(result)
}
