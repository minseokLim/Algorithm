package programmers.part2

import kotlin.math.ceil

class Lim42586 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val dayList = progresses.mapIndexed { idx, progress ->
            ceil((100 - progress) / speeds[idx].toDouble()).toInt()
        }

        val answer = mutableListOf<Int>()
        var count = 1
        var before = dayList[0]
        for (i in 1 until dayList.size) {
            if (before < dayList[i]) {
                answer.add(count)
                count = 1
                before = dayList[i]
            } else {
                count++
            }
        }
        answer.add(count)

        return answer.toIntArray()
    }
}
