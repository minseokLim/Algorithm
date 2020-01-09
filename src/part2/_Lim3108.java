package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Lim3108 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Rectangle> input = new LinkedList<Rectangle>();
		List<List<Rectangle>> lists = new ArrayList<List<Rectangle>>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			input.add(new Rectangle(x1, y1, x2, y2));
		}
		
		while(!input.isEmpty()) {
			Rectangle rec = input.remove(0);
			
			for(List<Rectangle> list : lists) {
				for(Rectangle elem : list) {
					if(elem.intersect(rec)) {
						list.add(rec);
						break;
					}
				}
			}
			
			List<Rectangle> newList = new ArrayList<Rectangle>();
		}
		
		System.out.println(input);
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
		
		public boolean intersect(Rectangle other) {
			return false;
		}
	}
}
