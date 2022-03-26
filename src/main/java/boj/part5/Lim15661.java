package boj.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lim15661 {
    private static int n;
    private static int[] horizontalSums;
    private static int[] verticalSums;
    private static int total = 0;
    private static int minGap = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        horizontalSums = new int[n];
        verticalSums = new int[n];

        for (int i = 0; i < n; i++) {
            int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            horizontalSums[i] = Arrays.stream(scores).sum();
            total += horizontalSums[i];
            for (int j = 0; j < n; j++) {
                verticalSums[j] += scores[j];
            }
        }

        for (int i = 0; i < n; i++) {
            solve(i, total, 1);
        }

        System.out.println(minGap);
    }

    private static void solve(final int userIdx, final int gap, final int depth) {
        if (depth == n) {
            return;
        }

        int localGap = gap - verticalSums[userIdx] - horizontalSums[userIdx];
        int abs = Math.abs(localGap);

        if (abs < minGap) {
            minGap = abs;
        }

        for (int i = userIdx + 1; i < n; i++) {
            solve(i, localGap, depth + 1);
        }
    }
}
