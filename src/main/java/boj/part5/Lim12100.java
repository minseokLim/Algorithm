package boj.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lim12100 {
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        dfs(board, 1);

        System.out.println(max);
    }

    private static void dfs(final int[][] board, final int depth) {
        for (final Direction direction : Direction.values()) {
            move(board, direction, depth);
        }
    }

    private static void move(final int[][] board, final Direction direction, final int depth) {
        final int[][] result = deepCopy(board);

        switch (direction) {
            case LEFT:
                rollLeft(result);
                for (int j = 1; j < result.length; j++) {
                    for (int i = 0; i < result.length; i++) {
                        if (result[i][j - 1] == result[i][j]) {
                            result[i][j - 1] *= 2;
                            result[i][j] = 0;
                        }
                    }
                }
                rollLeft(result);
                break;
            case RIGHT:
                rollRight(result);
                for (int j = result.length - 2; j >= 0; j--) {
                    for (int i = 0; i < result.length; i++) {
                        if (result[i][j + 1] == result[i][j]) {
                            result[i][j + 1] *= 2;
                            result[i][j] = 0;
                        }
                    }
                }
                rollRight(result);
                break;
            case TOP:
                rollTop(result);
                for (int i = 1; i < result.length; i++) {
                    for (int j = 0; j < result.length; j++) {
                        if (result[i - 1][j] == result[i][j]) {
                            result[i - 1][j] *= 2;
                            result[i][j] = 0;
                        }
                    }
                }
                rollTop(result);
                break;
            case BOTTOM:
                rollBottom(result);
                for (int i = result.length - 2; i >= 0; i--) {
                    for (int j = 0; j < result.length; j++) {
                        if (result[i + 1][j] == result[i][j]) {
                            result[i + 1][j] *= 2;
                            result[i][j] = 0;
                        }
                    }
                }
                rollBottom(result);
                break;
        }

        if (depth == 5) {
            final int localMax = getMax(result);

            if (localMax > max) {
                max = localMax;
            }

            return;
        }

        dfs(result, depth + 1);
    }

    private static void rollBottom(final int[][] result) {
        for (int i = result.length - 2; i >= 0; i--) {
            for (int j = 0; j < result.length; j++) {
                int temp = i;
                while (temp <= result.length - 2 && result[temp + 1][j] == 0 && result[temp][j] != 0) {
                    result[temp + 1][j] = result[temp][j];
                    result[temp][j] = 0;
                    temp++;
                }
            }
        }
    }

    private static void rollTop(final int[][] result) {
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                int temp = i;
                while (temp >= 1 && result[temp - 1][j] == 0 && result[temp][j] != 0) {
                    result[temp - 1][j] = result[temp][j];
                    result[temp][j] = 0;
                    temp--;
                }
            }
        }
    }

    private static void rollRight(final int[][] result) {
        for (int j = result.length - 2; j >= 0; j--) {
            for (int i = 0; i < result.length; i++) {
                int temp = j;
                while (temp <= result.length - 2 && result[i][temp + 1] == 0 && result[i][temp] != 0) {
                    result[i][temp + 1] = result[i][temp];
                    result[i][temp] = 0;
                    temp++;
                }
            }
        }
    }

    private static void rollLeft(final int[][] result) {
        for (int j = 1; j < result.length; j++) {
            for (int i = 0; i < result.length; i++) {
                int temp = j;
                while (temp >= 1 && result[i][temp - 1] == 0 && result[i][temp] != 0) {
                    result[i][temp - 1] = result[i][temp];
                    result[i][temp] = 0;
                    temp--;
                }
            }
        }
    }

    private static int[][] deepCopy(final int[][] board) {
        final int[][] result = new int[board.length][board.length];

        for (int i = 0; i < board.length; i++) {
            result[i] = Arrays.copyOf(board[i], board.length);
        }

        return result;
    }

    private static int getMax(final int[][] board) {
        int result = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] > result) {
                    result = board[i][j];
                }
            }
        }

        return result;
    }

    private enum Direction {
        LEFT, RIGHT, TOP, BOTTOM
    }
}
