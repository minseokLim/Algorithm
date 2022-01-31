package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val seq = br.readLine().split(" ").map { it.toInt() }
    val result = IntArray(n)
    result[n - 1] = -1

    for (i in n - 2 downTo 0) {
        if (seq[i] < seq[i + 1]) {
            result[i] = seq[i + 1]
        } else {
            var j = i + 1

            while (result[j] != -1 && result[j] <= seq[i]) {
                j++
            }

            result[i] = result[j]
        }
    }
    
    println(result.joinToString(" "))
}
