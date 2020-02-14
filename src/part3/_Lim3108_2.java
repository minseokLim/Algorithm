package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Lim3108_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Rectangle[] rectangles = new Rectangle[n];
		boolean[][] intersect = new boolean[n][n];
		boolean crossZero = false;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			rectangles[i] = new Rectangle(x1, y1, x2, y2);
			
			if(y1 == 0 && x1 * x2 <= 0 || y2 == 0 && x1 * x2 <= 0 || x1 == 0 && y1 * y2 <= 0 || x2 == 0 && y1 * y2 <= 0) {
				crossZero = true;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(rectangles[i].intersect(rectangles[j])) {
					intersect[i][j] = true;
				}
			}
		}
		
		boolean[] visited = new boolean[n];
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(rectangles, intersect, visited, i,  n);
				cnt++;
			}	
		}
		
		if(crossZero) cnt--;
		
		System.out.println(cnt);
	}

	private static void dfs(Rectangle[] rectangles, boolean[][] intersect, boolean[] visited, int i, int n) {
		visited[i] = true;
		
		for(int j = 0; j < n; j++) {
			if(!visited[j] && intersect[i][j]) {
				dfs(rectangles, intersect, visited, j, n);
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
		
		public boolean intersect(Rectangle rectangle) {
			int _x1 = rectangle.getX1();
			int _y1 = rectangle.getY1();
			int _x2 = rectangle.getX2();
			int _y2 = rectangle.getY2();
			
			return !(_x2 < x1 || x2 < _x1 || _y2 < y1 || y2 < _y1 || (x1 < _x1 && x2 > _x2 && y1 < _y1 && y2 > _y2) || (_x1 < x1 && _x2 > x2 && _y1 < y1 && _y2 > y2));
		}
	}
}
