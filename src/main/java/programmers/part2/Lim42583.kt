package programmers.part2

import java.util.LinkedList
import java.util.Queue

class Lim42583 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val bridgeQueue: Queue<Int> = LinkedList(List(bridge_length) { 0 })
        val waitingQueue: Queue<Int> = LinkedList(truck_weights.toList())

        var answer = 0
        while (bridgeQueue.isNotEmpty()) {
            answer++
            bridgeQueue.poll()

            if (waitingQueue.isNotEmpty()) {
                if (bridgeQueue.sum() + waitingQueue.peek() <= weight) {
                    bridgeQueue.offer(waitingQueue.poll())
                } else {
                    bridgeQueue.offer(0)
                }
            }
        }

        return answer
    }
}
