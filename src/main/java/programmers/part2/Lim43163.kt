package programmers.part2

import java.util.LinkedList
import java.util.Queue

class Lim43163 {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        val queue: Queue<Word> = LinkedList()
        val visited = BooleanArray(words.size)
        queue.offer(Word(begin, 0))

        while (queue.isNotEmpty()) {
            val polled = queue.poll()

            if (polled.value == target) {
                return polled.times
            }

            queue.addAll(polled.getNexts(words, visited))
        }

        return 0
    }

    private data class Word(
        val value: String,
        val times: Int
    ) {
        fun getNexts(words: Array<String>, visited: BooleanArray): List<Word> {
            val result = mutableListOf<Word>()
            for (i in words.indices) {
                if (!visited[i] && value.isChangeableTo(words[i])) {
                    visited[i] = true
                    result.add(Word(words[i], times + 1))
                }
            }
            return result
        }

        private fun String.isChangeableTo(other: String): Boolean {
            return this.filterIndexed { index, c -> c != other[index] }.count() == 1
        }
    }
}
