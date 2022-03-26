package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Lim1261_2 {	
	private static int[] di = {1, 0, -1, 0};
	private static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		if(m == 1 && n == 1) {
			br.readLine();
			System.out.println(0);
			return;
		}
		
		int[][] map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			char[] row = br.readLine().toCharArray();
			
			for(int j = 0; j < m; j++) {
				map[i][j] =  (row[j] - '0');
			}
		}
		
		boolean[][] visited = new boolean[n][m];
		int[][] ans = new int[n][m];
		
		Deque<Point> deque = new ArrayDeque<Point>();
		visited[0][0] = true;
		deque.add(new Point(0, 0));
		
		int answer = 0;
		
		outer : while(!deque.isEmpty()) {
			Point poll = deque.poll();
			int i = poll.getI();
			int j = poll.getJ();
			
			for(int k = 0; k < 4; k++) {
				int newI = i + di[k];
				int newJ = j + dj[k];
				
				if(newI >= 0 && newI < n && newJ >= 0 && newJ < m && !visited[newI][newJ]) {
					int val = map[newI][newJ];
					visited[newI][newJ] = true;
					
					if(val == 0) {
						ans[newI][newJ] = ans[i][j];						
						deque.addFirst(new Point(newI, newJ));
					}
					
					if(val == 1) {
						ans[newI][newJ] = ans[i][j] + 1;
						deque.addLast(new Point(newI, newJ));
					}
					
					if(newI == n - 1 && newJ == m - 1) {
						answer = ans[newI][newJ];
						break outer;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static class Point {
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
