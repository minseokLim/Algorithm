package boj.part1;

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
		
		System.out.println(bfs(f, s, g, u, d));		
	}
	
	private static String bfs(int f, int s, int g, int u, int d) {
		int answer = -1;
		Queue<Pair> queue = new LinkedList<Pair>();
		boolean[] visited = new boolean[f + 1];
		visited[s] = true;
		queue.add(new Pair(s, 0));
		
		while(!queue.isEmpty()) {
			Pair poll = queue.poll();
			int stair = poll.getStair();
			int cnt = poll.getCnt();
			
			if(stair == g) {
				answer = cnt;
				break;
			}
			
			int upstairs = stair + u;
			
			if(upstairs <= f && !visited[upstairs]) {
				visited[upstairs] = true;
				queue.add(new Pair(upstairs, cnt + 1));
			}
			
			int downstairs = stair - d;
			
			if(downstairs >= 1 && !visited[downstairs]) {
				visited[downstairs] = true;
				queue.add(new Pair(downstairs, cnt + 1));
			}
		}
		
		if(answer == -1) {
			return "use the stairs";
		} else {
			return String.valueOf(answer);
		}
	}
	
	private static class Pair {
		private int stair;
		private int cnt;
		
		public Pair(int stair, int cnt) {
			this.stair = stair;
			this.cnt = cnt;
		}

		public int getStair() {
			return stair;
		}

		public int getCnt() {
			return cnt;
		}
	}
}
