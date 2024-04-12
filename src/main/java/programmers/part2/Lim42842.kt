package programmers.part2

class Lim42842 {
    fun solution(brown: Int, yellow: Int): IntArray {
        val sum = brown / 2 + 2 // 가로와 세로의 합
        for (i in 3..sum - 3) {
            if ((i - 2) * (sum - i - 2) == yellow) {
                return intArrayOf(sum - i, i)
            }
        }
        return intArrayOf()
    }
}
