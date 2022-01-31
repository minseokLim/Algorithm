package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()

    val stack = IntArray(n)
    var cursor = -1
    val sb = StringBuilder()
    var i = 1

    while(n-- > 0) {
        val next = br.readLine().toInt()

        while(cursor == -1 || stack[cursor] < next) {
            stack[++cursor] = i++
            sb.append("+\n")
        }

        if(stack[cursor--] == next) {
            sb.append("-\n")
        } else {
            println("NO")
            return
        }
    }

    println(sb)
}
