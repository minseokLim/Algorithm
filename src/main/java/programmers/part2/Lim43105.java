package programmers.part2;

import java.util.Arrays;

public class Lim43105 {
    public int solution(int[][] triangle) {
        final int[][] maxes = new int[triangle.length][triangle.length];
        maxes[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    maxes[i][j] = triangle[i][j] + maxes[i - 1][j];
                } else if (j == i) {
                    maxes[i][j] = triangle[i][j] + maxes[i - 1][j - 1];
                } else {
                    maxes[i][j] = triangle[i][j] + Math.max(maxes[i - 1][j], maxes[i - 1][j - 1]);
                }
            }
        }

        return Arrays.stream(maxes[triangle.length - 1]).max().getAsInt();
    }
}
