package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

private val combinations = mutableSetOf<List<Int>>()
private val permutations = mutableSetOf<List<Int>>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.extractNumbers()
    val numbers = br.extractNumbers()

    val combination = IntArray(m)
    for (i in 0 until n) {
        solve(i, 0, combination, numbers)
    }

    combinations.forEach {
        permutation(0, it.toIntArray())
    }

    val answer = permutations
        .sortedBy { list ->
            list.fold(BigInteger.ZERO) { sortValue, it ->
                sortValue.multiply(BigInteger.valueOf(10000)).add(BigInteger.valueOf(it.toLong()))
            }
        }
        .joinToString(System.lineSeparator()) { it.joinToString(" ") }

    println(answer)
}

private fun BufferedReader.extractNumbers() = this.readLine().split(" ").map { it.toInt() }

private fun solve(idx: Int, depth: Int, combination: IntArray, numbers: List<Int>) {
    combination[depth] = numbers[idx]

    if (depth == combination.size - 1) {
        combinations.add(combination.toList())
        return
    }

    for (i in idx + 1 until numbers.size) {
        solve(i, depth + 1, combination, numbers)
    }
}

private fun permutation(depth: Int, combination: IntArray) {
    if (depth == combination.size - 1) {
        permutations.add(combination.toList())
        return
    }

    for (i in depth until combination.size) {
        swap(i, depth, combination)
        permutation(depth + 1, combination)
        swap(i, depth, combination)
    }
}

private fun swap(x: Int, y: Int, combination: IntArray) {
    val temp = combination[x]
    combination[x] = combination[y]
    combination[y] = temp
}
