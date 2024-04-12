package programmers.part2

class Lim42747 {
    fun solution(citations: IntArray): Int {
        citations.sortDescending()

        var count = 0
        for (citation in citations) {
            if (citation > count) {
                count++
            } else {
                break
            }
        }

        return count
    }
}
