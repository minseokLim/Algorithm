package programmers.part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lim1844 {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int solution(int[][] maps) {
        final int n = maps.length;
        final int m = maps[0].length;

        final Queue<Player> queue = new LinkedList<>();
        final boolean[][] visited = new boolean[n][m];
        queue.offer(new Player(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            final Player polled = queue.poll();

            if (polled.i == n - 1 && polled.j == m - 1) {
                return polled.times;
            }

            queue.addAll(polled.getNexts(maps, visited));
        }

        return -1;
    }

    private static class Player {
        int i;
        int j;
        int times;

        public Player(int i, int j, int times) {
            this.i = i;
            this.j = j;
            this.times = times;
        }

        public List<Player> getNexts(int[][] maps, boolean[][] visited) {
            final int n = maps.length;
            final int m = maps[0].length;

            final List<Player> result = new ArrayList<>();
            for (int[] direction : directions) {
                final int nextI = i + direction[0];
                final int nextJ = j + direction[1];

                if (nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < m && maps[nextI][nextJ] == 1 && !visited[nextI][nextJ]) {
                    visited[nextI][nextJ] = true;
                    result.add(new Player(nextI, nextJ, times + 1));
                }
            }
            return result;
        }
    }
}
