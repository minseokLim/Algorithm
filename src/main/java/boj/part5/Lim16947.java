package boj.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Lim16947 {
    private static int n;
    private static Map<Integer, List<Integer>> connected;
    private static boolean[] visited;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        connected = new HashMap<>();
        visited = new boolean[n];
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken()) - 1;
            final int b = Integer.parseInt(st.nextToken()) - 1;

            connected.putIfAbsent(a, new ArrayList<>());
            connected.putIfAbsent(b, new ArrayList<>());
            connected.get(a).add(b);
            connected.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            answer[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (answer[i] == -1) {
                findCyclePoint(-1, i);
                visited[i] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (answer[i] == -1) {
                dfsRemaining(i, 1);
                visited[i] = false;
            }
        }

        printAnswer();
    }

    private static int findCyclePoint(final int before, final int now) {
        visited[now] = true;

        for (final int i : connected.get(now)) {
            if (!visited[i]) {
                final int cyclePoint = findCyclePoint(now, i);
                visited[i] = false;

                if (cyclePoint != -1) {
                    if (cyclePoint == now) {
                        return -1;
                    }

                    answer[now] = 0;
                    return cyclePoint;
                }
            } else if (before != -1 && before != i) {
                answer[i] = 0;
                return i;
            }
        }

        return -1;
    }

    private static int dfsRemaining(final int now, final int depth) {
        visited[now] = true;

        for (final int i : connected.get(now)) {
            if (answer[i] == -1 && !visited[i]) {
                final int value = dfsRemaining(i, depth + 1);
                visited[i] = false;

                if (value != -1) {
                    answer[now] = value - depth + 1;
                    return value;
                }
            } else if (answer[i] != -1) {
                answer[now] = answer[i] + 1;
                return depth + answer[i];
            }
        }

        return -1;
    }

    private static void printAnswer() {
        final StringJoiner result = new StringJoiner(" ");
        for (final int element : answer) {
            result.add(String.valueOf(element));
        }
        System.out.println(result);
    }
}
