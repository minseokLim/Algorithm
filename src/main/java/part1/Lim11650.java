package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim11650 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Point> queue = new PriorityQueue<>();
		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			queue.offer(p);
		}
		
		while(!queue.isEmpty()) {
			sb.append(queue.poll() + "\n");
		}
		
		System.out.println(sb);
	}
	
	static class Point implements Comparable<Point> {
		private int x;
		private int y;
	
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if(x == o.x) {
				return y - o.y;
			}
			
			return x - o.x;
		}

		@Override
		public String toString() {
			return x + " " + y;
		}
	}
}
