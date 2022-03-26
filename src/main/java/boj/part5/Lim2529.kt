package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private var k = 0
private lateinit var signs: CharArray
private var max = Long.MIN_VALUE
private var min = Long.MAX_VALUE
private lateinit var maxStr: String
private lateinit var minStr: String
private val checked = BooleanArray(10)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    k = br.readLine().toInt()
    signs = br.readLine().replace(" ", "").toCharArray()

    val numbers = IntArray(k + 1)

    for (i in 0..9) {
        numbers[0] = i
        checked[i] = true
        solve(0, numbers)
        checked[i] = false
    }

    println(maxStr)
    println(minStr)
}

private fun solve(depth: Int, numbers: IntArray) {
    if (depth == k) {
        val value = numbers.joinToString("")
        val numberValue = value.toLong()

        if (min > numberValue) {
            min = numberValue
            minStr = value
        }

        if (max < numberValue) {
            max = numberValue
            maxStr = value
        }

        return
    }

    for (i in 0..9) {
        if (!checked[i]) {
            val match = when (signs[depth]) {
                '<' -> numbers[depth] < i
                '>' -> numbers[depth] > i
                else -> throw Exception()
            }

            if (match) {
                numbers[depth + 1] = i
                checked[i] = true
                solve(depth + 1, numbers)
                checked[i] = false
            }
        }
    }
}
