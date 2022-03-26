package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val leftStack = Stack<Char>()
    val rightStack = Stack<Char>()
    br.readLine().forEach { leftStack.push(it) }
    var m = br.readLine().toInt()

    while(m-- > 0) {
        val command = br.readLine()

        when(command[0]) {
            'L' -> if(leftStack.isNotEmpty()) rightStack.push(leftStack.pop())
            'D' -> if(rightStack.isNotEmpty()) leftStack.push(rightStack.pop())
            'B' -> if(leftStack.isNotEmpty()) leftStack.pop()
            'P' -> leftStack.push(command[2])
        }
    }

    val sb = StringBuilder()

    leftStack.forEach { sb.append(it) }

    while(rightStack.isNotEmpty()) {
        sb.append(rightStack.pop())
    }

    println(sb)
}
