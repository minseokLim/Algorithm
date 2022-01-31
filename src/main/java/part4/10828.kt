package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val stack = Stack<Int>()

    for(i in 1..n) {
        val input = br.readLine().split(" ")

        when(input[0]) {
            "push" -> stack.push(input[1].toInt())
            "pop" -> if(stack.isEmpty()) println(-1) else println(stack.pop())
            "size" -> println(stack.size)
            "empty" -> if(stack.isEmpty()) println(1) else println(0)
            "top" -> if(stack.isEmpty()) println(-1) else println(stack.peek())
        }
    }
}
