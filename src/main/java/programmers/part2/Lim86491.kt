package programmers.part2

class Lim86491 {
    fun solution(sizes: Array<IntArray>): Int {
        sizes.forEach {
            if (it[0] < it[1]) {
                swap(it)
            }
        }

        return sizes.maxOf { it[0] } * sizes.maxOf { it[1] }
    }

    private fun swap(size: IntArray) {
        val temp = size[0]
        size[0] = size[1]
        size[1] = temp
    }
}
