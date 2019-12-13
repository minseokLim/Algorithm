package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim2146 {
	private static int[] di = {1, -1, 0, 0};
	private static int[] dj = {0, 0, 1, -1};
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		boolean[][] isIsland = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				if("1".equals(st.nextToken())) {
					isIsland[i][j] = true;
				}
			}
		}
		
		boolean[][] visited = new boolean[N][N];
		int[][] map = new int[N][N];
		int color = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(isIsland[i][j] && !visited[i][j]) {
					dfs(isIsland, visited, map, i, j, ++color, N);
				}
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(isIsland[i][j]) {
					visited = new boolean[N][N];
					bfs(isIsland, visited, map, i, j, N);
				}
			}
		}
		
		System.out.println(min);
	}

	private static void bfs(boolean[][] isIsland, boolean[][] visited, int[][] map, int i, int j, int n) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(i, j, 0));
		int color = map[i][j];
		
		outer : while(!queue.isEmpty()) {
			Point poll = queue.poll();
			int pI = poll.getI();
			int pJ = poll.getJ();
			int pCnt = poll.getCnt();
			
			for(int k = 0; k < 4; k++) {
				int nextI = pI + di[k];
				int nextJ = pJ + dj[k];
				
				if(nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < n) {
					if(!isIsland[nextI][nextJ] && !visited[nextI][nextJ]) {
						visited[nextI][nextJ] = true;
						queue.offer(new Point(nextI, nextJ, pCnt + 1));
					} else if(isIsland[nextI][nextJ] && color != map[nextI][nextJ]) {
						if(pCnt < min) {
							min = pCnt;
						}
						
						break outer;
					}
				}
			}
		}
	}

	private static void dfs(boolean[][] isIsland, boolean[][] visited, int[][] map, int i, int j, int color, int n) {
		visited[i][j] = true;
		map[i][j] = color;
		
		for(int k = 0; k < 4; k++) {
			int nextI = i + di[k];
			int nextJ = j + dj[k];
			
			if(nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < n) {
				if(isIsland[nextI][nextJ] && !visited[nextI][nextJ]) {
					dfs(isIsland, visited, map, nextI, nextJ, color, n);
				}
			}
		}
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
