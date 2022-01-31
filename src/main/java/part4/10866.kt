package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val deque = ArrayDeque<Int>()
    val sb = StringBuilder()

    while(n-- > 0) {
        val command = br.readLine().split(" ")

        try {
            when(command[0]) {
                "push_front" -> deque.addFirst(command[1].toInt())
                "push_back" -> deque.addLast(command[1].toInt())
                "pop_front" -> sb.append("${deque.removeFirst()}\n")
                "pop_back" -> sb.append("${deque.removeLast()}\n")
                "size" -> sb.append("${deque.size}\n")
                "empty" -> if(deque.isEmpty()) sb.append("1\n") else sb.append("0\n")
                "front" -> sb.append("${deque.first()}\n")
                "back" -> sb.append("${deque.last()}\n")
            }
        } catch (e: NoSuchElementException) {
            sb.append("-1\n")
        }

    }

    println(sb)
}
