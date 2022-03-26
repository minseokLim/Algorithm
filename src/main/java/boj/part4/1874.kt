package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()

    val stack = Stack<Int>()
    val list = mutableListOf<Char>()
    var i = 1

    while(n-- > 0) {
        val next = br.readLine().toInt()

        while(stack.isEmpty() || stack.peek() < next) {
            stack.push(i++)
            list.add('+')
        }

        if(stack.pop() == next) {
            list.add('-')
        } else {
            println("NO")
            return
        }
    }

    list.forEach{ println(it) }
}
