package part5

import java.io.BufferedReader
import java.io.InputStreamReader

private val heights = mutableListOf<Int>()
private var answer = listOf<Int>()
private var done = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    repeat(9) {
        heights.add(br.readLine().toInt())
    }

    for (i in 0..2) {
        val dwarfs = mutableSetOf<Int>()
        accumulate(dwarfs, i, 1)
    }

    answer.forEach {
        println(it)
    }
}

fun accumulate(dwarfs: MutableSet<Int>, index: Int, depth: Int) {
    if (done) {
        return
    }

    dwarfs.add(heights[index])

    if (depth == 7) {
        if (dwarfs.sum() == 100) {
            answer = dwarfs.sorted()
            done = true
        }
        return
    }

    for (i in index + 1 until 9) {
        accumulate(dwarfs, i, depth + 1)
        dwarfs.remove(heights[i])
    }
}
