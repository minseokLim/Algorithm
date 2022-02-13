package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim14501 {
    private static int n;
    private static int[][] schedules;
    private static int max = 0;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        schedules = new int[n][2];
        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (i + schedules[i][0] > n) {
                continue;
            }

            solve(i);
            answer -= schedules[i][1];
        }

        System.out.println(max);
    }

    private static void solve(final int idx) {
        answer += schedules[idx][1];

        if (answer > max) {
            max = answer;
        }

        for (int i = idx + schedules[idx][0]; i < n; i++) {
            if (i + schedules[i][0] > n) {
                continue;
            }

            solve(i);
            answer -= schedules[i][1];
        }
    }
}
