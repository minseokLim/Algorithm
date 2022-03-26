package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private var answer = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val robots = BooleanArray(n)

    while (a.count { it == 0 } < k) {
        answer++
        rotate(a, robots)
        moveRobot(a, robots)
        if (a[0] > 0) {
            robots[0] = true
            a[0]--
        }
    }

    println(answer)
}

private fun rotate(a: IntArray, robots: BooleanArray) {
    val tmp = a[a.size - 1]

    for (i in a.size - 1 downTo 1) {
        a[i] = a[i - 1]
    }
    a[0] = tmp

    for (i in robots.size - 2 downTo 1) {
        robots[i] = robots[i - 1]
    }
    robots[robots.size - 1] = false
    robots[0] = false
}

private fun moveRobot(a: IntArray, robots: BooleanArray) {
    for (i in robots.size - 1 downTo 1) {
        if (a[i] > 0 && robots[i - 1] && robots[i].not()) {
            a[i]--
            robots[i] = true
            robots[i - 1] = false
        }
    }
    robots[robots.size - 1] = false
}
