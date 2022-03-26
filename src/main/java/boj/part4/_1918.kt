package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.Stack

fun Char.priority() = when(this) {
    '(' -> 0
    '+', '-' -> 1
    '*', '/' -> 2
    else -> throw IllegalArgumentException()
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val stack = Stack<Char>()
    val answer = StringBuilder()

    for (c in input) {
        when (c) {
            in 'A'..'Z' -> answer.append(c)
            '(' -> stack.push(c)
            ')' -> {
                while (stack.peek() != '(') {
                    answer.append(stack.pop())
                }
                stack.pop()
            }
            else -> {
                while (stack.isNotEmpty() && stack.peek().priority() >= c.priority()) {
                    answer.append(stack.pop())
                }
                stack.push(c)
            }
        }
    }
}
