package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim2178 {
	private static int[] di = {0, 0, -1, 1};
	private static int[] dj = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] maze = new boolean[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j = 0; j < m; j++) {
				if(input[j] == '1') {
					maze[i][j] = true;
				}
			}
		}
		
		int min = bfs(maze, visited, n, m);
		
		System.out.println(min);
	}

	private static int bfs(boolean[][] maze, boolean[][] visited, int n, int m) {
		int ret = 0;
		visited[0][0] = true;
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0, 0, 1));
		
		outer : while(!queue.isEmpty()) {
			Point poll = queue.poll();
			int i = poll.getI();
			int j = poll.getJ();
			int cnt = poll.getCnt();
			
			for(int k = 0; k < 4; k++) {
				int nextI = i + di[k];
				int nextJ = j + dj[k];
				
				if(nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < m) {
					if(maze[nextI][nextJ] && !visited[nextI][nextJ]) {
						if(nextI == n - 1 && nextJ == m - 1) {
							ret = cnt + 1;
							break outer;
						}
						
						visited[nextI][nextJ] = true;
						queue.add(new Point(nextI, nextJ, cnt + 1));
					}
				}
			}
		}
		
		return ret;
	}
	
	private static class Point {
		private int i;
		private int j;
		private int cnt;
		
		public Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}

		public int getI() {
			return i;
		}

		public int getJ() {
			return j;
		}

		public int getCnt() {
			return cnt;
		}
	}
}
