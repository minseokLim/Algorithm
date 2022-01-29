package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Lim2146 {
	private static int[] di = {1, 0, -1, 0};
	private static int[] dj = {0, 1, 0, -1};
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[n][n];
		int[][] newMap = new int[n][n];
		boolean[][] visit = new boolean[n][n];		
		
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < n; j++) {
				
				if(input.charAt(2 * j) == '1') {
					map[i][j] = true;
				}
			}
		}
		
		int color = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				if(!visit[i][j] && map[i][j]) {
					colorMap(map, newMap, visit, i, j, color++, n);
				}
			}
		}
				
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {			
				if(map[i][j]) {					
					for(int k = 0; k < 4; k++) {
						int nextI = i + di[k];
						int nextJ = j + dj[k];	
						
						if(nextI >= n || nextI < 0 || nextJ >= n || nextJ < 0) {
							continue;
						}
						
						if(!map[nextI][nextJ]) {
							visit = new boolean[n][n];							
							searchBridge(map, newMap, visit, nextI, nextJ, n, newMap[i][j]);
						}
					}
				}
			}
		}
		
		System.out.println(min);
	}

	private static void searchBridge(boolean[][] map, int[][] newMap, boolean[][] visit, int i, int j, int n, int currentColor) {
		int cnt = 1;
		Queue<Point> queue = new LinkedList<Point>();
		
		visit[i][j] = true;
		queue.add(new Point(i, j));
		
		outer : while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int k = 0; k < size; k++) {
				Point p = queue.poll(); 
				
				for(int l = 0; l < 4; l++) {
					int nextI = p.getI() + di[l];
					int nextJ = p.getJ() + dj[l];
					
					if(nextI >= n || nextI < 0 || nextJ >= n || nextJ < 0) {
						continue;
					}
					
					if(!map[nextI][nextJ] && !visit[nextI][nextJ]) {
						visit[nextI][nextJ] = true;
						queue.add(new Point(nextI, nextJ));
					} else if(map[nextI][nextJ] && newMap[nextI][nextJ] != currentColor) {
						if(min > cnt) {
							min = cnt;
						}
						break outer;
					}
				}
			}
			
			cnt++;
		}
	}
	
	private static void colorMap(boolean[][] map, int[][] newMap, boolean[][] visit, int i, int j, int color, int n) {
		visit[i][j] = true;
		newMap[i][j] = color;
		
		for(int k = 0; k < 4; k++) {
			int nextI = i + di[k];
			int nextJ = j + dj[k];
			
			if(nextI >= n || nextI < 0 || nextJ >= n || nextJ < 0) {
				continue;
			}
			
			if(!visit[nextI][nextJ] && map[nextI][nextJ]) {
				colorMap(map, newMap, visit, nextI, nextJ, color, n);
			}
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
