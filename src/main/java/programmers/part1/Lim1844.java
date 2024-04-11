package programmers.part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lim1844 {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] maps) {
        final var point = new Point(0, 0, 1);
        final var visited = new boolean[maps.length][maps[0].length];

        final Queue<Point> queue = new LinkedList<>();
        queue.offer(point);

        while (!queue.isEmpty()) {
            final Point polled = queue.poll();
            if (polled.i == (maps.length - 1) && polled.j == maps[0].length - 1) {
                return polled.times;
            }

            queue.addAll(polled.getNexts(maps, visited));
        }

        return -1;
    }

    static class Point {
        int i;
        int j;
        int times;

        public Point(int i, int j, int times) {
            this.i = i;
            this.j = j;
            this.times = times;
        }

        public List<Point> getNexts(int[][] maps, boolean[][] visited) {
            final int maxI = maps.length - 1;
            final int maxJ = maps[0].length - 1;
            final List<Point> result = new ArrayList<>();

            for (int[] direction : directions) {
                final int nextI = i + direction[0];
                final int nextJ = j + direction[1];

                if (nextI >= 0 && nextJ >= 0 && nextI <= maxI && nextJ <= maxJ && maps[nextI][nextJ] == 1 && !visited[nextI][nextJ]) {
                    visited[nextI][nextJ] = true;
                    result.add(new Point(nextI, nextJ, times + 1));
                }
            }
            return result;
        }
    }
}
