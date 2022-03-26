package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim5014 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int min = bfs(f, s, g, u, d);
		
		if(min == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(min);
		}
	}

	private static int bfs(int f, int s, int g, int u, int d) {
		boolean[] visited = new boolean[f + 1];
		visited[s] = true;
		Queue<Status> queue = new LinkedList<>();
		queue.offer(new Status(s, 0));
		
		while(!queue.isEmpty()) {
			Status poll = queue.poll();
			int floor = poll.getFloor();
			int time = poll.getTime();
			
			if(floor == g) {
				return time;
			}
			
			int nextFloor = floor + u;
			
			if(nextFloor <= f && !visited[nextFloor]) {
				visited[nextFloor] = true;
				queue.offer(new Status(nextFloor, time + 1));
			}
			
			nextFloor = floor - d;
			
			if(nextFloor >= 0 && !visited[nextFloor]) {
				visited[nextFloor] = true;
				queue.offer(new Status(nextFloor, time + 1));
			}
		}
		
		return -1;
	}
	
	private static class Status {
		private int floor;
		private int time;
		
		public Status(int floor, int time) {
			this.floor = floor;
			this.time = time;
		}

		public int getFloor() {
			return floor;
		}
		public int getTime() {
			return time;
		}
	}
}
