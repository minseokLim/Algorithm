package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val answer = StringJoiner(System.lineSeparator())

    repeat(t) {
        var (m, n, x, y) = br.readLine().split(" ").map { it.toInt() }

        if (x == y) {
            answer.add(x.toString())
            return@repeat
        }

        if (m < n) {
            var tmp = m
            m = n
            n = tmp

            tmp = x
            x = y
            y = tmp
        }

        var i = 0
        var order = -1
        var count = 0

        while (i != n) {
            if ((i + x).specialMod(n) == y) {
                order = count * m + x
                break
            }

            i = (i + m).specialMod(n)
            count++
        }

        answer.add(order.toString())
    }

    println(answer)
}

private fun Int.specialMod(n: Int): Int {
    val result = this % n

    return if (result == 0) {
        n
    } else {
        result
    }
}
