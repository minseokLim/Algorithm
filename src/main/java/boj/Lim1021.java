package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Lim1021 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        final int N = inputs.get(0);

        final List<Integer> targets = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        final LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
        }

        int count = 0;
        for (int target : targets) {
            final int idx = deque.indexOf(target);
            final int leftCost = idx;
            final int rightCost = deque.size() - idx;
            count += Math.min(leftCost, rightCost);
            deque.remove(idx);
            Collections.rotate(deque, -idx);
        }

        System.out.println(count);
    }
}
