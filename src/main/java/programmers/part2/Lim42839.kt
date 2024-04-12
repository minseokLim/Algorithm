package programmers.part2

class Lim42839 {
    private var answers = mutableSetOf<Int>()
    private val isPrime = BooleanArray(10000000) { true }

    fun solution(numbers: String): Int {
        isPrime[0] = false
        isPrime[1] = false
        for (i in 2 until isPrime.size) {
            if (isPrime[i]) {
                var j = i * 2
                while (j < isPrime.size) {
                    isPrime[j] = false
                    j += i
                }
            }
        }

        val visited = BooleanArray(numbers.length)
        for (i in numbers.indices) {
            solve(i, numbers, listOf(), visited)
            visited[i] = false
        }

        return answers.size
    }

    private fun solve(idx: Int, numbers: String, x: List<Char>, visited: BooleanArray) {
        visited[idx] = true
        val next = x + numbers[idx]
        val number = next.joinToString("").toInt()
        if (isPrime[number]) {
            answers.add(number)
        }

        for (i in numbers.indices) {
            if (!visited[i]) {
                solve(i, numbers, next, visited)
                visited[i] = false
            }
        }
    }
}
