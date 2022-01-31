package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var cnt = IntArray(10) { 1 }

    for (i in 2..n) {
        val tmp = IntArray(10)

        for (j in 0..9) {
            for (k in 0..j) {
                tmp[j] = (tmp[j] + cnt[k]) % 10007
            }
        }

        cnt = tmp
    }

    println(cnt.sum() % 10007)
}
