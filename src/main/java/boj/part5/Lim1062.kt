package boj.part5

import java.io.BufferedReader
import java.io.InputStreamReader

private const val PREFIX = "anta"
private const val SUFFIX = "tica"
private const val BASIC_COUNT = 5

private var max = 0
private var learned = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val words = mutableListOf<String>()

    for(i in 0 until n) {
        val input = br.readLine()
        words.add(input.substringAfter(PREFIX).substringBeforeLast(SUFFIX))
    }

    if (k < BASIC_COUNT) {
        println(0)
    } else {
        val basicCharacterIndexes = (PREFIX + SUFFIX).map { it - 'a' }.distinct()
        basicCharacterIndexes
            .forEach {
                learned = learned.or(1.shl(it))
            }

        if (k == BASIC_COUNT) {
            println(getCount(words, learned))
        } else {
            val characterIndexes = (0..25).filter { it !in basicCharacterIndexes }

            for (i in characterIndexes.indices) {
                dfs(i, characterIndexes, 1, k, words)
                learned = learned.and(1.shl(characterIndexes[i]).inv())
            }

            println(max)
        }
    }
}

private fun dfs(idx: Int, characterIndexes: List<Int>, depth: Int, k: Int, words: List<String>) {
    learned = learned.or(1.shl(characterIndexes[idx]))

    if (depth == k - BASIC_COUNT) {
        val count = getCount(words, learned)
        if (count > max) {
            max = count
        }

        return
    }

    for (i in idx + 1 until characterIndexes.size) {
        dfs(i, characterIndexes, depth + 1, k, words)
        learned = learned.and(1.shl(characterIndexes[i]).inv())
    }
}

private fun getCount(words: List<String>, learned: Int): Int {
    var result = 0

    for (word in words) {
        var match = true

        word.forEach {
            if (1.shl(it - 'a').and(learned) == 0) {
                match = false
                return@forEach
            }
        }

        if (match) {
            result++
        }
    }

    return result
}

