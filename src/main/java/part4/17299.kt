package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }

    val freqMap = IntArray(1000001)

    for (x in seq) {
        freqMap[x]++
    }

    val result = IntArray(n)
    result[n - 1] = -1

    for (i in n - 2 downTo 0) {
        if (freqMap[seq[i]] < freqMap[seq[i + 1]]) {
            result[i] = seq[i + 1]
        } else {
            var j = i + 1

            while (result[j] != -1 && freqMap[seq[j]] <= freqMap[seq[i]]) {
                j++
            }

            if (result[j] == -1 && freqMap[seq[j]] <= freqMap[seq[i]]) {
                result[i] = -1
            } else {
                result[i] = seq[j]
            }
        }
    }

    println(result.joinToString(" "))
}
