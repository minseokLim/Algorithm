package programmers.part2

class Lim43165 {
    private var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {
        solve(0, numbers, target, 0, true)
        solve(0, numbers, target, 0, false)

        return answer
    }

    private fun solve(idx: Int, numbers: IntArray, target: Int, sum: Int, add: Boolean) {
        val tempSum = if (add) {
            sum + numbers[idx]
        } else {
            sum - numbers[idx]
        }

        if (idx == numbers.size - 1) {
            if (tempSum == target) {
                answer++
            }
            return
        }

        solve(idx + 1, numbers, target, tempSum, true)
        solve(idx + 1, numbers, target, tempSum, false)
    }
}
