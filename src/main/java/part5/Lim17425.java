package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Lim17425 {
    public static final int MAX = 1000000;
    private static long[] fx = new long[MAX + 1];
    private static long[] dp = new long[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int t = Integer.parseInt(br.readLine());
        final List<Integer> inputs = new ArrayList<>();
        final StringJoiner result = new StringJoiner(System.lineSeparator());

        for (int i = 0; i < t; i++) {
            final int n = Integer.parseInt(br.readLine());
            inputs.add(n);
        }

        computeAnswer(MAX);

        for (final int input : inputs) {
            result.add(String.valueOf(dp[input]));
        }

        System.out.println(result);
    }

    private static void computeAnswer(final int max) {
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                fx[j] += i;
            }
        }

        dp[1] = 1;
        for (int i = 2; i <= max; i++) {
            dp[i] = dp[i - 1] + fx[i];
        }
    }
}
