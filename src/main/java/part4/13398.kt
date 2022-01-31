package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }

    if (n > 1) {
        val maxes = IntArray(n)
        val conMaxes = IntArray(n)
        maxes[0] = seq[0]
        conMaxes[0] = maxes[0]

        fun max(vararg numbers: Int): Int {
            return numbers.maxOrNull()!!
        }

        maxes[1] = max(seq[1], seq[0] + seq[1])
        conMaxes[1] = maxes[1]

        for (i in 2 until n) {
            maxes[i] = max(maxes[i - 1] + seq[i], conMaxes[i - 2] + seq[i], seq[i])
            conMaxes[i] = max(conMaxes[i - 1] + seq[i], seq[i])
        }

        println(maxes.maxOrNull()!!)
    } else {
        println(seq[0])
    }
}
