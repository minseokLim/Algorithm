package boj.part8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lim2589 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = br.readLine().split(" ");
        final int I = Integer.parseInt(input[0]);
        final int J = Integer.parseInt(input[1]);

        final boolean[][] map = new boolean[I][J];
        for (int i = 0; i < I; i++) {
            final String line = br.readLine();
            for (int j = 0; j < J; j++) {
                map[i][j] = line.charAt(j) == 'L';
            }
        }

        int answer = 0;

        for(int i = 0; i < I; i++) {
            for(int j = 0; j < J; j++) {
                if(map[i][j]) {
                    final boolean[][] visited = new boolean[I][J];
                    answer = Math.max(answer, bfs(map, visited, i, j));
                }
            }
        }

        System.out.println(answer);
    }

    private static int bfs(boolean[][] map, boolean[][] visited, int i, int j) {
        final Point start = new Point(i, j, 0);
        final Queue<Point> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(start);
        int max = 0;

        while(!queue.isEmpty()) {
            final Point polled = queue.poll();

            if(polled.time > max) {
                max = polled.time;
            }

            queue.addAll(polled.getNexts(map, visited));
        }

        return max;
    }

    private static class Point {
        private int i;
        private int j;
        private int time;

        public Point(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }

        public List<Point> getNexts(boolean[][] map, boolean[][] visited) {
            final ArrayList<Point> result = new ArrayList<>();
            if (i - 1 >= 0 && map[i - 1][j] && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                result.add(new Point(i - 1, j, time + 1));
            }
            if (i + 1 < map.length && map[i + 1][j] && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                result.add(new Point(i + 1, j, time + 1));
            }
            if (j - 1 >= 0 && map[i][j - 1] && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                result.add(new Point(i, j - 1, time + 1));
            }
            if (j + 1 < map[0].length && map[i][j + 1] && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                result.add(new Point(i, j + 1, time + 1));
            }
            return result;
        }
    }
}
