package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Lim14889 {
    private static int n;
    private static int[][] scores;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scores = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            scores[i] = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        }

        int[] picked = new int[n / 2];
        pick(0, picked, 0);

        System.out.println(min);
    }

    private static void pick(final int target, final int[] picked, final int depth) {
        picked[depth] = target;

        if (n / 2 - 1 == depth) {
            int[] others = IntStream.range(0, n)
                    .filter(elem ->
                            Arrays.stream(picked)
                                    .noneMatch(a -> a == elem)
                    ).toArray();

            int score1 = calculateScore(picked, 0, 0);
            int score2 = calculateScore(others, 0, 0);
            int gap = Math.abs(score1 - score2);

            if (gap < min) {
                min = gap;
            }

            return;
        }

        for (int i = target + 1; i < n; i++) {
            pick(i, picked, depth + 1);
        }
    }

    private static int calculateScore(final int[] members, final int idx, int score) {
        if (idx == n / 2 - 1) {
            return score;
        }

        for (int i = idx + 1; i < n / 2; i++) {
            score += scores[members[idx]][members[i]] + scores[members[i]][members[idx]];
        }

        return calculateScore(members, idx + 1, score);
    }
}
