package part5

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var seq: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    seq = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var answer = "-1"

    for (i in 2..n) {
        if (seq.isDescending(n - i, n).not()) {
            solve(n - i)
            answer = seq.joinToString(" ")
            break
        }
    }

    println(answer)
}


fun IntArray.isDescending(from: Int, to: Int): Boolean {
    for (i in from until to - 1) {
        if (this[i] < this[i + 1]) {
            return false
        }
    }

    return true
}

private fun solve(replaceIdx: Int) {
    val set = seq.copyOfRange(replaceIdx, seq.size).toMutableSet()
    val nextInt = nextInt(set, seq[replaceIdx])
    set.remove(nextInt)

    val backPart = (listOf(nextInt) + set.sorted()).toIntArray()
    backPart.copyInto(seq, replaceIdx, 0, backPart.size)
}

fun nextInt(numbers: Collection<Int>, n: Int): Int {
    numbers.sorted().forEach {
        if (it > n) {
            return it
        }
    }
    throw IllegalArgumentException()
}
