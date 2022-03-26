package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim11651 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] points = new Point[n];
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());			
			points[i] = new Point(x, y);
		}
		
		Arrays.sort(points);		
		Arrays.stream(points).forEach(e -> sb.append(e + "\n"));
		
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
		public String toString() {
			return x + " " + y;
		}

		@Override
		public int compareTo(Point o) {
			int ret = this.y - o.y;
			
			if(ret != 0) {
				return ret;
			} else {
				return this.x - o.x;
			}
		}
	}
}
