package boj.part8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lim1927 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        final StringBuilder answer = new StringBuilder();
        final Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            final int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                priorityQueue.add(x);
            } else {
                if (priorityQueue.isEmpty()) {
                    answer.append(0).append("\n");
                } else {
                    answer.append(priorityQueue.poll()).append("\n");
                }
            }
        }

        System.out.println(answer);
    }
}
