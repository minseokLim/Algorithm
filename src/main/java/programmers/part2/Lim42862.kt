package programmers.part2

class Lim42862 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val gymClothes = IntArray(n) { 1 }
        lost.forEach {
            gymClothes[it - 1]--
        }
        reserve.forEach {
            gymClothes[it - 1]++
        }

        for (i in 0 until n) {
            if (gymClothes[i] == 0 && i - 1 >= 0 && gymClothes[i - 1] == 2) {
                gymClothes[i]++
                gymClothes[i - 1]--
            }

            if (gymClothes[i] == 0 && i + 1 < n && gymClothes[i + 1] == 2) {
                gymClothes[i]++
                gymClothes[i + 1]--
            }
        }

        return gymClothes.count { it >= 1 }
    }
}
