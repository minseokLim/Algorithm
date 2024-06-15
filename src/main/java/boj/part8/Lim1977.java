package boj.part8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lim1977 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int M = Integer.parseInt(br.readLine());
        final int N = Integer.parseInt(br.readLine());

        final List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= N; i++) {
            if (i * i >= M) {
                list.add(i * i);
            }
        }

        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            final int sum = list.stream()
                .mapToInt(it -> it)
                .sum();
            System.out.println(sum);
            System.out.println(list.get(0));
        }
    }
}
