package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }
    val partSeqs = Array<MutableList<Int>>(n) { mutableListOf() }

    partSeqs[n - 1].add(seq[n - 1])

    for (i in (n - 2) downTo 0) {
        var maxIdx = -1

        for (j in (i + 1) until n) {
            if (seq[i] < seq[j]) {
                if (maxIdx == -1 || partSeqs[j].size > partSeqs[maxIdx].size) {
                    maxIdx = j
                }
            }
        }

        partSeqs[i].add(seq[i])

        if (maxIdx != -1) partSeqs[i].addAll(partSeqs[maxIdx])
    }

    val answer = partSeqs.maxByOrNull { it.size }!!
    println(answer.size)
    println(answer.joinToString(" "))
}
