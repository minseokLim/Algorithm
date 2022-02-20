package part5

import java.io.BufferedReader
import java.io.InputStreamReader

private var n = 0
private lateinit var s: Array<CharArray>
private lateinit var seq: IntArray
private var solved = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    val signSeq = br.readLine()
    s = Array(n) { CharArray(n) }
    seq = IntArray(n)

    var startIdx = 0
    val iterator = signSeq.iterator()
    while (iterator.hasNext()) {
        for (i in startIdx until n) {
            s[startIdx][i] = iterator.nextChar()
        }
        startIdx++
    }


    for (i in -10..10) {
        solve(i, 0)
    }
}

private fun solve(element: Int, targetIdx: Int) {
    seq[targetIdx] = element
    if (solved || !isValid(targetIdx)) {
        return
    }
    if (targetIdx == n - 1) {
        solved = true
        println(seq.joinToString(" "))
        return
    }

    for (i in -10..10) {
        solve(i, targetIdx + 1)
    }
}

private fun isValid(targetIdx: Int): Boolean {
    for (i in 0..targetIdx) {
        val matched = seq.sum(i, targetIdx).match(s[i][targetIdx])
        if (!matched) {
            return false
        }
    }

    return true
}

private fun IntArray.sum(from: Int, to: Int): Int {
    var result = 0
    for (i in from..to) {
        result += this[i]
    }

    return result
}

private fun Int.match(sign: Char): Boolean {
    return when (sign) {
        '+' -> this > 0
        '-' -> this < 0
        '0' -> this == 0
        else -> throw IllegalArgumentException()
    }
}
