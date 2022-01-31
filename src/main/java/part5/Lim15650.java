package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Lim15650 {
    private static int n;
    private static int m;
    private static final StringJoiner ANSWER = new StringJoiner(System.lineSeparator());
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        for (int i = 1; i <= n; i++) {
            solve(i, 0);
        }

        System.out.println(ANSWER);
    }

    private static void solve(final int target, final int depth) {
        arr[depth] = target;

        if (depth == m - 1) {
            final String result = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

            ANSWER.add(result);
            return;
        }

        for (int i = target + 1; i <= n; i++) {
            solve(i, depth + 1);
        }
    }
}
