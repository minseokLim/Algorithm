package boj.part4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.regex.Pattern

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()

    val regex = Regex("<(\\w| )+>|(\\w|\\d)+")
    val wordPattern = Pattern.compile("(\\w|\\d)+")

    val words = regex.findAll(input)
    val result = words.map {
        if (wordPattern.matcher(it.value).matches()) {
            it.value.reversed()
        } else it.value
    }.joinToString(" ").replace("> ", ">").replace(" <", "<")

    println(result)
}
