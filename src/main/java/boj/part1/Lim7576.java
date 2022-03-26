package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim7576 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] tomatos = new int[n][m];
		int totalCNT = n * m;
		int cnt = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		Queue<Point> queue = new LinkedList<Point>();
		
		int days = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) {
				tomatos[i][j] = Integer.parseInt(st.nextToken());
				
				if(tomatos[i][j] == 1) {
					queue.add(new Point(j, i));
					cnt++;
				} else if(tomatos[i][j] == -1) {
					totalCNT--;
				}
			}
		}
		
		while(true) {
			int size = queue.size();
			
			for(int j = 0; j < size; j++) {
				Point point = queue.poll();
				int x = point.getX();
				int y = point.getY();
				
				for(int i = 0; i < 4; i++) {
					if(x + dx[i] >= m || y + dy[i] >= n || x + dx[i] < 0 || y + dy[i] < 0) {
						continue;
					}
					
					if(tomatos[y + dy[i]][x + dx[i]] == 0) {
						tomatos[y + dy[i]][x + dx[i]] = 1;
						queue.add(new Point(x + dx[i], y + dy[i]));
						cnt++;
					}
				}
			}
			
			if(!queue.isEmpty()) {
				days++;
			} else {
				break;
			}
		}
		
		if(cnt == totalCNT) {
			System.out.println(days);
		} else {
			System.out.println(-1);
		}
		
	}
	
	static class Point {
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
}
