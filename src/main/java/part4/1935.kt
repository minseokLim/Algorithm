package part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val input = br.readLine().toCharArray()
    val numbers = IntArray(n)

    for (i in 0 until n) {
        numbers[i] = br.readLine().toInt()
    }

    val list = LinkedList<Any>()

    for (c in input) {
        if (c in 'A'..'Z') {
            list.add(numbers[c - 'A'].toDouble())
        } else {
            list.add(c)
        }
    }

    while (list.size > 1) {
        for ((idx, obj) in list.withIndex()) {
            if (obj !is Double) {
                val result = when (obj) {
                    '*' -> list[idx - 2] as Double * list[idx - 1] as Double
                    '/' -> list[idx - 2] as Double / list[idx - 1] as Double
                    '-' -> list[idx - 2] as Double - list[idx - 1] as Double
                    '+' -> list[idx - 2] as Double + list[idx - 1] as Double
                    else -> throw IllegalArgumentException()
                }

                list.removeAt(idx)
                list.removeAt(idx - 1)
                list.removeAt(idx - 2)

                list.add(idx - 2, result)

                break
            }
        }
    }

    println(String.format("%.2f", list[0]))
}
