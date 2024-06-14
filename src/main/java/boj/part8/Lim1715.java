package boj.part8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Lim1715 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (priorityQueue.size() > 1) {
            final int a = priorityQueue.poll();
            final int b = priorityQueue.poll();
            sum += a + b;
            priorityQueue.offer(a + b);
        }

        System.out.println(sum);
    }
}
