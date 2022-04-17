package boj.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim16929 {
    private static int n;
    private static int m;
    private static char[][] board;
    private static boolean[][] visited;
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static String answer = "No";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(-1, -1, i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(final int beforeI, final int beforeJ, final int thisI, final int thisJ) {
        visited[thisI][thisJ] = true;

        for (final int[] direction : directions) {
            final int nextI = thisI + direction[0];
            final int nextJ = thisJ + direction[1];

            if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m && board[thisI][thisJ] == board[nextI][nextJ]) {
                if (beforeI != -1 && (nextI != beforeI || nextJ != beforeJ) && visited[nextI][nextJ]) {
                    answer = "Yes";
                    break;
                }

                if (!visited[nextI][nextJ]) {
                    dfs(thisI, thisJ, nextI, nextJ);
                }
            }
        }
    }
}
