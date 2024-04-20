package programmers.part2

class Lim43162 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        val visited = BooleanArray(n)
        var answer = 0
        for (i in computers.indices) {
            if (!visited[i]) {
                dfs(i, computers, visited)
                answer++
            }
        }

        return answer
    }

    private fun dfs(idx: Int, computers: Array<IntArray>, visited: BooleanArray) {
        visited[idx] = true

        for (i in computers.indices) {
            if (computers[idx][i] == 1 && !visited[i]) {
                dfs(i, computers, visited)
            }
        }
    }
}
