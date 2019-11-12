package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim3108 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Rectangle[] rectangles = new Rectangle[n + 1];
		boolean[] visited = new boolean[n + 1];
		
		// 직사각형이 0,0을 지날 경우, 처음부터 연필을 들어올릴 필요가 없어지므로 존재하는 직사각형 중에 0,0을 지나는 것이 있는지의 여부에 따라 cnt에서 1을 뺴느냐의 여부가 달라진다.
		// 따라서 인위적으로 모든 점이 0인 직사각형을 하나 집어 넣은 후에 cnt에서 1을 무조건 빼면, 존재하는 직사각형 중 0,0을 지나는 것이 있는지를 체크할 필요가 없다.
		rectangles[0] = new Rectangle(0, 0, 0, 0);
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			rectangles[i] = new Rectangle(x1, y1, x2, y2);			
		}
		
		int idx;
		int cnt = 0;
		
		while((idx = findRemainIdx(visited)) != -1) {
			
			Queue<Rectangle> queue = new LinkedList<Rectangle>();
			visited[idx] = true;
			queue.add(rectangles[idx]);
			
			while(!queue.isEmpty()) {
				Rectangle poll = queue.poll();
				
				for(int i = 0; i <= n; i++) {
					
					if(!visited[i] && poll.intersect(rectangles[i])) {
						visited[i] = true;
						queue.add(rectangles[i]);
					}
				}
			}
			
			cnt++;
		}	
		
		System.out.println(cnt - 1);
	}

	private static int findRemainIdx(boolean[] visited) {
		int ret = -1;
		
		for(int i = 0; i < visited.length; i++) {
			
			if(!visited[i]) {
				ret = i;
				break;
			}
		}
		
		return ret;
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
		
		public boolean intersect(Rectangle rec) {
			boolean inner = (this.x1 < rec.getX1() && this.x2 > rec.getX2() && this.y1 < rec.getY1() && this.y2 > rec.getY2()) || (this.x1 > rec.getX1() && this.x2 < rec.getX2() && this.y1 > rec.getY1() && this.y2 < rec.getY2());
			
			if(!inner && this.x2 >= rec.getX1() && this.x1 <= rec.getX2() && this.y2 >= rec.getY1() && this.y1 <= rec.getY2()) {
				return true;
			} else {
				return false;
			}
		}
	}
}
