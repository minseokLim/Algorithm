package programmers.part2

class Lim84512 {
    private val vowels = listOf('A', 'E', 'I', 'O', 'U')
    private var answer = 0
    private var solved = false

    fun solution(word: String): Int {
        for (i in vowels.indices) {
            dfs(i, emptyList(), word, 1)
        }

        return answer
    }

    private fun dfs(idx: Int, x: List<Char>, word: String, depth: Int) {
        if (solved.not()) {
            answer++
            val next = x + vowels[idx]

            if (next.joinToString("") == word) {
                solved = true
                return
            }
            if (depth == 5) {
                return
            }

            for (i in vowels.indices) {
                dfs(i, next, word, depth + 1)
            }
        }
    }
}
