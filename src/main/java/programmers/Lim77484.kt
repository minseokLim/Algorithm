package programmers

class Lim77484 {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val zeroCount = lottos.count { it == 0 }
        val matchCount = lottos.countIn(win_nums)

        return intArrayOf(grade(zeroCount + matchCount), grade(matchCount))
    }

    private fun grade(matchCount: Int): Int {
        return when (matchCount) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            else -> 6
        }
    }

    private fun IntArray.countIn(target: IntArray): Int {
        return this.count { target.contains(it) }
    }
}
