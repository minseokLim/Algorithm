package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim2178 {
	private static int[] di = {1, 0, -1, 0};
	private static int[] dj = {0, 1, 0, -1};
	private static Queue<Point> queue = new LinkedList<Point>();
	private static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] maze = new boolean[n][m];
		boolean[][] visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < m; j++) {
				
				if(input.charAt(j) == '1') {
					maze[i][j] = true;
				}
			}
		}
		
		bfsMethod(maze, visit, n, m);
		
		System.out.println(cnt);
	}

	private static void bfsMethod(boolean[][] maze, boolean[][] visit, int n, int m) {
		cnt++;
		visit[0][0] = true;
		queue.add(new Point(0, 0));
		
		outer : while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for(int h = 0; h < size; h++) {
				
				Point p = queue.poll();
				int i = p.getI();
				int j = p.getJ();
				
				for(int k = 0; k < 4; k++) {
					
					int nextI = i + di[k];
					int nextJ = j + dj[k];
					
					if(nextI >= n || nextI < 0 || nextJ >= m || nextJ < 0) {
						continue;
					}
					
					if(maze[nextI][nextJ] && !visit[nextI][nextJ]) {
						
						if(nextI == n - 1 && nextJ == m - 1) {
							cnt++;
							break outer;
						}
						
						visit[nextI][nextJ] = true;
						queue.add(new Point(nextI, nextJ));
					}
				}
			}
			
			cnt++;
		}
	}
	
	static class Point {
		private int i;
		private int j;
		
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public int getJ() {
			return j;
		}
	}
}
