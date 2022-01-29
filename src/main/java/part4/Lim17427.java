package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lim17427 {
    public static final int MAX = 1000000;
    private static long[] fx = new long[MAX + 1];
    private static long[] dp = new long[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        computeAnswer(n);

        System.out.println(dp[n]);
    }

    private static void computeAnswer(final int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                fx[j] += i;
            }
        }

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + fx[i];
        }
    }
}
