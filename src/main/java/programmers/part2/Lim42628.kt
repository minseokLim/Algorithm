package programmers.part2

import java.util.PriorityQueue

class Lim42628 {
    fun solution(operations: Array<String>): IntArray {
        val ascPriorityQueue = PriorityQueue<Int>()
        val descPriorityQueue = PriorityQueue<Int> { o1, o2 -> o2 - o1 }

        operations.forEach {
            val arr = it.split(" ")
            if (arr[0] == "I") {
                ascPriorityQueue.add(arr[1].toInt())
                descPriorityQueue.add(arr[1].toInt())
            } else {
                if (ascPriorityQueue.isNotEmpty()) {
                    if (arr[1] == "-1") {
                        val polled = ascPriorityQueue.poll()
                        descPriorityQueue.remove(polled)
                    } else {
                        val polled = descPriorityQueue.poll()
                        ascPriorityQueue.remove(polled)
                    }
                }
            }
        }

        return if (ascPriorityQueue.isEmpty()) {
            intArrayOf(0, 0)
        } else {
            intArrayOf(descPriorityQueue.peek(), ascPriorityQueue.peek())
        }
    }
}
