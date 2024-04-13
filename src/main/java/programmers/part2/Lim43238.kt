package programmers.part2

class Lim43238 {
    fun solution(n: Int, times: IntArray): Long {
        var answer = Long.MAX_VALUE
        var left = 0L
        var right = times.maxOf { it } * n.toLong()

        while (left <= right) {
            val mid = (left + right) / 2
            val completed = times.sumOf { mid / it }

            if (completed < n) {
                left = mid + 1
            } else {
                right = mid - 1
                answer = mid
            }
        }

        return answer
    }
}
