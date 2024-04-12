package programmers.part2

class Lim42840 {
    fun solution(answers: IntArray): IntArray {
        val person1 = intArrayOf(1, 2, 3, 4, 5)
        val person2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val person3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        val counts = intArrayOf(0, 0, 0)

        for (i in answers.indices) {
            if (answers[i] == person1[i % person1.size]) {
                counts[0]++
            }
            if (answers[i] == person2[i % person2.size]) {
                counts[1]++
            }
            if (answers[i] == person3[i % person3.size]) {
                counts[2]++
            }
        }

        val max = counts.maxOf { it }
        val answer = mutableListOf<Int>()
        for (i in counts.indices) {
            if (counts[i] == max) {
                answer.add(i + 1)
            }
        }

        return answer.toIntArray()
    }
}
