package boj.part6

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val answer = StringBuilder()
    val stack = Stack<Char>()

    br.readLine().forEach {
        when (it) {
            in 'A'..'Z' -> answer.append(it)
            '(' -> stack.push(it)
            ')' -> {
                while (!stack.empty() && stack.peek() != '(') {
                    answer.append(stack.pop())
                }
                stack.pop()
            }
            '*', '/' -> {
                while (!stack.empty() && !(stack.peek() != '*' && stack.peek() != '/')) {
                    answer.append(stack.pop())
                }
                stack.push(it)
            }
            else -> {
                while (!stack.empty() && stack.peek() != '(') {
                    answer.append(stack.pop())
                }
                stack.push(it)
            }
        }
    }
    while (!stack.empty()) {
        answer.append(stack.pop())
    }

    println(answer)
}
