package programmers.part2

class Lim181188 {
    fun solution(targets: Array<IntArray>): Int {
        targets.sortWith(compareBy<IntArray> { it[1] }.thenBy { it[0] })
        var answer = 0
        var beforeBound = targets[0][1]
        for (i in 0 until targets.size - 1) {
            if (beforeBound <= targets[i + 1][0]) {
                answer++
                beforeBound = targets[i + 1][1]
            }
        }

        return answer + 1
    }
}
