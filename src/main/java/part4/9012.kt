package part4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var t = br.readLine().toInt()

    while(t-- > 0) {
        val input = br.readLine().toCharArray()

        val stack = Stack()
        var yes = true

        input.forEach {
            when(it) {
                '(' -> stack.push()
                ')' -> if(stack.pop() < 0) {
                    yes = false
                    return@forEach
                }
            }
        }

        if(yes && stack.cursor == 0) println("YES") else println("NO")
    }
}

class Stack {
    var cursor = 0

    fun push() = ++cursor

    fun pop()  = --cursor
}
