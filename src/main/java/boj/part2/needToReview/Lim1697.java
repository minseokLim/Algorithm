package boj.part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim1697 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int min = Math.abs(n - k);
		
		if(n < k) {
			min = bfs(n, k);
		}
		
		System.out.println(min);
	}

	private static int bfs(int n, int k) {
		boolean[] visited = new boolean[200001];
		visited[n] = true;
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(n, 0));
		int min = 0;
		
		while(!queue.isEmpty()) {
			Point poll = queue.poll();
			int idx = poll.getIdx();
			int time = poll.getTime();
			
			if(idx == k) {
				min = time;
				break;
			}
			
			if(idx < k) {
				if(idx != 0 && !visited[idx * 2]) {
					visited[idx * 2] = true;
					queue.offer(new Point(idx * 2, time + 1));
				}
				
				if(!visited[idx + 1]) {
					visited[idx + 1] = true;
					queue.offer(new Point(idx + 1, time + 1));
				}
			}
					
			if(idx > 0 && !visited[idx - 1]) {
				visited[idx - 1] = true;
				queue.offer(new Point(idx - 1, time + 1));
			}		
		}
		
		return min;
	}
	
	private static class Point {
		private int idx;
		private int time;
		
		public Point(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}

		public int getIdx() {
			return idx;
		}

		public int getTime() {
			return time;
		}
	}
}
