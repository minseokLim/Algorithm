package part1;

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
		int answer;
		
		if(n >= k) {
			answer = n - k;
		} else {
			answer = bfs(n, k);
		}
		
		System.out.println(answer);
	}

	private static int bfs(int n, int k) {
		int answer = 0;
		boolean[] visited = new boolean[200000];
		Queue<Position> queue = new LinkedList<Position>();
		visited[n] = true;
		queue.add(new Position(n, 0, true, true));
		
		while(!queue.isEmpty()) {
			Position poll = queue.poll();			
			int newN = poll.getN();
			int time = poll.getTime();
			boolean canPlus = poll.isCanPlus();
			boolean canMinus = poll.isCanMinus();
			
			if(newN == k) {
				answer = poll.getTime();
				break;
			} else if(newN < k) {
				if(newN != 0 && !visited[newN * 2]) {
					visited[newN * 2] = true;
					queue.add(new Position(newN * 2, time + 1, true, true));
				}
							
				if(canPlus && !visited[newN + 1]) {
					visited[newN + 1] = true;
					queue.add(new Position(newN + 1, time + 1, true, false));
				}			
			}
			
			if(canMinus && newN - 1 > 0 && !visited[newN - 1]) {
				visited[newN - 1] = true;
				queue.add(new Position(newN - 1, time + 1, false, true));
			}		
		}
		
		return answer;
	}

	private static class Position {
		private int n;
		private int time;
		private boolean canPlus;
		private boolean canMinus;
		
		public Position(int n, int time, boolean canPlus, boolean canMinus) {
			this.n = n;
			this.time = time;
			this.canPlus = canPlus;
			this.canMinus = canMinus;
		}

		public int getN() {
			return n;
		}

		public int getTime() {
			return time;
		}

		public boolean isCanPlus() {
			return canPlus;
		}

		public boolean isCanMinus() {
			return canMinus;
		}
	}
}
