package programmers.skillcheck

class Test2 {
    fun solution(brown: Int, yellow: Int): IntArray {
        return solve(brown, yellow)!!
    }
    
    private fun solve(brown: Int, yellow: Int): IntArray? {
        val xySum = (brown + 4) / 2

        for (i in 3..xySum / 2) {
            val x = i
            val y = xySum - x

            if ((x - 2) * (y - 2) == yellow) {
                return intArrayOf(y, x)
            }
        }
        return null
    }
}
