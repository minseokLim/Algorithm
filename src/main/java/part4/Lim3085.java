package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lim3085 {
    private static int max = 0;
    private static int n;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        final char[][] candies = new char[n][n];

        for (int i = 0; i < n; i++) {
            candies[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && candies[i][j] != candies[i][j + 1]) {
                    change(candies, i, j, i, j + 1);
                    search(candies);
                    change(candies, i, j, i, j + 1);
                }

                if (i + 1 < n && candies[i][j] != candies[i + 1][j]) {
                    change(candies, i, j, i + 1, j);
                    search(candies);
                    change(candies, i, j, i + 1, j);
                }
            }
        }

        System.out.println(max);
    }

    private static void change(final char[][] candies, final int i, final int j, final int i2, final int j2) {
        final char temp = candies[i][j];
        candies[i][j] = candies[i2][j2];
        candies[i2][j2] = temp;
    }

    private static void search(final char[][] candies) {
        for (int i = 0; i < n; i++) {
            searchHorizontal(candies, i, 0);
            searchVertical(candies, 0, i);
        }
    }

    private static void searchHorizontal(final char[][] candies, final int i, final int j) {
        int length = 1;

        for (int k = j + 1; k < n; k++) {
            if (candies[i][j] == candies[i][k]) {
                length++;
            } else {
                searchHorizontal(candies, i, k);
                break;
            }
        }

        if (length > max) {
            max = length;
        }
    }

    private static void searchVertical(final char[][] candies, final int i, final int j) {
        int length = 1;

        for (int k = i + 1; k < n; k++) {
            if (candies[i][j] == candies[k][j]) {
                length++;
            } else {
                searchVertical(candies, k, j);
                break;
            }
        }

        if (length > max) {
            max = length;
        }
    }
}
