package part5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ")
    val s = input[0].toInt()
    val n = input[1]

    val answer = StringBuilder()
    val resultSet = mutableListOf<List<String>>()

    for (number in n) {
        val printSet = when (number) {
            '1' -> one(s)
            '2' -> two(s)
            '3' -> three(s)
            '4' -> four(s)
            '5' -> five(s)
            '6' -> six(s)
            '7' -> seven(s)
            '8' -> eight(s)
            '9' -> nine(s)
            '0' -> zero(s)
            else -> throw IllegalArgumentException()
        }

        resultSet.add(printSet)
    }

    for (i in 0 until 2 * s + 3) {
        resultSet.forEach {
            answer.append(it[i]).append(" ")
        }
        answer.append(System.lineSeparator())
    }

    println(answer)
}

private fun zero(s: Int): List<String> {
    val result = mutableListOf<String>()
    addHorizontalLine(result, s)
    addTwoVerticalLines(result, s)
    addHorizontalEmptySpace(result, s)
    addTwoVerticalLines(result, s)
    addHorizontalLine(result, s)

    return result
}

private fun nine(s: Int): List<String> {
    val result = mutableListOf<String>()
    addHorizontalLine(result, s)
    addTwoVerticalLines(result, s)
    addHorizontalLine(result, s)
    addRightVerticalLine(result, s)
    addHorizontalLine(result, s)

    return result
}

private fun eight(s: Int): List<String> {
    val result = mutableListOf<String>()
    addHorizontalLine(result, s)
    addTwoVerticalLines(result, s)
    addHorizontalLine(result, s)
    addTwoVerticalLines(result, s)
    addHorizontalLine(result, s)

    return result
}

private fun seven(s: Int): List<String> {
    val result = mutableListOf<String>()
    addHorizontalLine(result, s)
    addRightVerticalLine(result, s)
    addHorizontalEmptySpace(result, s)
    addRightVerticalLine(result, s)
    addHorizontalEmptySpace(result, s)

    return result
}

private fun six(s: Int): List<String> {
    val result = mutableListOf<String>()
    addHorizontalLine(result, s)
    addLeftVerticalLine(result, s)
    addHorizontalLine(result, s)
    addTwoVerticalLines(result, s)
    addHorizontalLine(result, s)

    return result
}

private fun five(s: Int): List<String> {
    val result = mutableListOf<String>()
    addHorizontalLine(result, s)
    addLeftVerticalLine(result, s)
    addHorizontalLine(result, s)
    addRightVerticalLine(result, s)
    addHorizontalLine(result, s)

    return result
}

private fun four(s: Int): List<String> {
    val result = mutableListOf<String>()
    addHorizontalEmptySpace(result, s)
    addTwoVerticalLines(result, s)
    addHorizontalLine(result, s)
    addRightVerticalLine(result, s)
    addHorizontalEmptySpace(result, s)

    return result
}

private fun three(s: Int): List<String> {
    val result = mutableListOf<String>()
    addHorizontalLine(result, s)
    addRightVerticalLine(result, s)
    addHorizontalLine(result, s)
    addRightVerticalLine(result, s)
    addHorizontalLine(result, s)

    return result
}

private fun two(s: Int): List<String> {
    val result = mutableListOf<String>()
    addHorizontalLine(result, s)
    addRightVerticalLine(result, s)
    addHorizontalLine(result, s)
    addLeftVerticalLine(result, s)
    addHorizontalLine(result, s)

    return result
}

private fun one(s: Int): List<String> {
    val result = mutableListOf<String>()
    addHorizontalEmptySpace(result, s)
    addRightVerticalLine(result, s)
    addHorizontalEmptySpace(result, s)
    addRightVerticalLine(result, s)
    addHorizontalEmptySpace(result, s)

    return result
}

private fun addTwoVerticalLines(
    result: MutableList<String>,
    s: Int
) {
    val width = s + 2
    repeat(s) {
        result.add("|" + " ".multiply(width - 2) + "|")
    }
}

private fun addLeftVerticalLine(
    result: MutableList<String>,
    s: Int
) {
    val width = s + 2
    repeat(s) {
        result.add("|" + " ".multiply(width - 1))
    }
}

private fun addRightVerticalLine(
    result: MutableList<String>,
    s: Int
) {
    val width = s + 2
    repeat(s) {
        result.add(" ".multiply(width - 1) + "|")
    }
}

private fun addHorizontalLine(result: MutableList<String>, s: Int) {
    result.add(" " + "-".multiply(s) + " ")
}

private fun addHorizontalEmptySpace(result: MutableList<String>, s: Int) {
    val width = s + 2
    result.add(" ".multiply(width))
}

private fun String.multiply(n: Int): String {
    val result = StringBuilder(this)

    repeat(n - 1) {
        result.append(this)
    }

    return result.toString()
}
