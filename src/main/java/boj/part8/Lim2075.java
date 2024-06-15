package boj.part8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Lim2075 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            final int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            for (int x : inputs) {
                if (priorityQueue.size() == N) {
                    if (priorityQueue.peek() < x) {
                        priorityQueue.poll();
                        priorityQueue.offer(x);
                    }
                } else {
                    priorityQueue.offer(x);
                }
            }
        }
        System.out.println(priorityQueue.poll());
    }
}
