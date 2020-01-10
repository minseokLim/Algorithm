package part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim3108 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Rectangle[] input = new Rectangle[n];
		boolean[][] matrix = new boolean[n][n];
		boolean crossZeroPoint = false;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			input[i] = new Rectangle(x1, y1, x2, y2);
			
			if((x1 == 0 || x2 == 0) && y1 * y2 <= 0 || (y1 == 0 || y2 == 0) && x1 * x2 <= 0) {
				crossZeroPoint = true;
			}
		}
		
		for(int i = 0; i < n; i++) {
			Rectangle rec = input[i];
			
			for(int j = 0; j < n; j++) {
				if(i != j) {
					Rectangle other = input[j];
					
					if(rec.intersect(other)) {
						matrix[i][j] = true;
					}
				}			
			}
		}
		
		boolean[] visited = new boolean[n];
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(matrix, visited, n, i);
				cnt++;
			}		
		}
		
		if(crossZeroPoint) cnt--;
		
		System.out.println(cnt);
	}
	
	private static void dfs(boolean[][] matrix, boolean[] visited, int n, int idx) {
		visited[idx] = true;
		
		for(int i = 0; i < n; i++) {
			if(matrix[idx][i] && !visited[i]) {
				dfs(matrix, visited, n, i);
			}
		}
	}

	private static class Rectangle {
		private int x1;
		private int y1;
		private int x2;
		private int y2;
		
		public Rectangle(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		public int getX1() {
			return x1;
		}

		public int getY1() {
			return y1;
		}

		public int getX2() {
			return x2;
		}

		public int getY2() {
			return y2;
		}
		
		// 이 조건을 실수 없이 구해내는 게 까다롭다.
		public boolean intersect(Rectangle other) {
			boolean condition1 = this.x2 < other.getX1() || this.y2 < other.getY1();
			boolean condition2 = other.getX2() < this.x1 || other.getY2() < this.y1;
			boolean condition3 = this.x1 < other.getX1() && this.y1 < other.getY1() && this.x2 > other.getX2() && this.y2 > other.getY2();
			boolean condition4 = other.getX1() < this.x1 && other.getY1() < this.y1 && other.getX2() > this.x2 && other.getY2() > this.y2;
			
			if(!condition1 && !condition2 && !condition3 && !condition4) {
				return true;
			}
			
			return false;
		}
	}
}
