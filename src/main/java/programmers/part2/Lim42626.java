package programmers.part2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Lim42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = Arrays.stream(scoville)
            .boxed()
            .collect(Collectors.toCollection(PriorityQueue::new));
        boolean solved = false;

        while (true) {
            final Integer min = priorityQueue.peek();
            if (min >= K) {
                solved = true;
                break;
            }

            if (priorityQueue.size() < 2) {
                break;
            }

            final int next = priorityQueue.poll() + priorityQueue.poll() * 2;
            priorityQueue.offer(next);
            answer++;
        }

        if (!solved) {
            return -1;
        }

        return answer;
    }
}
