package boj.part8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Lim2776_2 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        final StringBuilder result = new StringBuilder();
        for(int i = 0; i < T; i++) {
            br.readLine();
            final Set<Integer> memo1 = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
            br.readLine();
            Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .forEach(
                    number -> result.append(memo1.contains(number) ? 1 : 0).append("\n")
                );
        }
        System.out.println(result);
    }
}
