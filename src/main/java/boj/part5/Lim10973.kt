package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var seq: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    seq = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var answer = "-1"

    for (i in 2..n) {
        if (seq.isAscending(n - i, n - 1).not()) {
            val numbers = seq.copyOfRange(n - i, n).toMutableSet()
            seq[n - i] = seq[n - i].nextInt(numbers)
            numbers.remove(seq[n - i])

            numbers.sortedDescending().toIntArray().copyInto(seq, n - i + 1, 0, numbers.size)
            answer = seq.joinToString(" ")
            break
        }
    }

    println(answer)
}

private fun IntArray.isAscending(from: Int, to: Int): Boolean {
    for (i in from until to) {
        if (this[i] > this[i + 1]) {
            return false
        }
    }
    return true
}

private fun Int.nextInt(numbers: Collection<Int>): Int {
    numbers.sortedDescending().forEach {
        if (it < this) {
            return it
        }
    }
    throw IllegalArgumentException()
}
