package part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var answer = 0L

    for (i in 1..n) {
        answer += (n / i) * i
    }

    println(answer)
}
