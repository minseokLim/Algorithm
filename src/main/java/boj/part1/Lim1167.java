package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim1167 {
	private static int diameter = 0;
	private static int start = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		
		@SuppressWarnings("unchecked")
		List<Point>[] lists = new ArrayList[v + 1];
		
		for(int i = 1; i <= v; i++) {
			lists[i] = new ArrayList<Point>();
		}
		
		for(int i = 1; i <= v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());		
			int m;
			
			while((m = Integer.parseInt(st.nextToken())) != -1) {
				lists[n].add(new Point(m, Integer.parseInt(st.nextToken())));
			}
		}
		
		bfsMethod(lists, start, v);
		bfsMethod(lists, start, v);
		
		System.out.println(diameter);
	}
	
	private static void bfsMethod(List<Point>[] lists, int i, int v) {
		boolean[] visit = new boolean[v + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		visit[i] = true;
		queue.add(i);
		queue2.add(0);
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			List<Point> list = lists[a];
			int initDistance = queue2.poll();
			
			if(initDistance > diameter) {
				diameter = initDistance;
				start = a;
			}
			
			for(Point p : list) {
				int idx = p.getIdx();
				
				if(!visit[idx]) {
					visit[idx] = true;
					queue.add(idx);
					queue2.add(initDistance + p.getDistance());
				}
			}
		}
	}

	static class Point {
		private int idx;
		private int distance;
		
		public Point(int idx, int distance) {
			this.idx = idx;
			this.distance = distance;
		}

		public int getIdx() {
			return idx;
		}

		public int getDistance() {
			return distance;
		}
	}
}
