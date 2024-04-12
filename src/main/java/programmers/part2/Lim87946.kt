package programmers.part2

class Lim87946 {
    private var answer = 0

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val visited = BooleanArray(dungeons.size)

        for (i in dungeons.indices) {
            if (!visited[i] && k >= dungeons[i][0]) {
                solve(i, dungeons, visited, k, 1)
                visited[i] = false
            }
        }

        return answer
    }

    private fun solve(idx: Int, dungeons: Array<IntArray>, visited: BooleanArray, currentK: Int, depth: Int) {
        visited[idx] = true
        val nextK = currentK - dungeons[idx][1]

        if (depth > answer) {
            answer = depth
        }

        for (i in dungeons.indices) {
            if (!visited[i] && nextK >= dungeons[i][0]) {
                solve(i, dungeons, visited, nextK, depth + 1)
                visited[i] = false
            }
        }
    }
}
