package part3;

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
		
		if(n >= k) {
			System.out.println(n - k);
		} else {
			boolean[] visited = new boolean[200001];
			visited[n] = true;
			Queue<Status> queue = new LinkedList<Status>();
			queue.offer(new Status(n, 0));
			
			int answer = 0;
			
			outer : while(!queue.isEmpty()) {
				Status poll = queue.poll();
				int position = poll.getPosition();
				int time = poll.getTime();
					
				for(int i = 0; i < 3; i++) {
					int nextPosition = getNextPosition(position, k, i);
					
					if(nextPosition != -1 && !visited[nextPosition]) {
						
						if(nextPosition == k) {
							answer = time + 1;
							break outer;
						}
						
						visited[nextPosition] = true;
						queue.offer(new Status(nextPosition, time + 1));
					}
				}
			}
			
			System.out.println(answer);
		}
	}
	
	private static int getNextPosition(int position, int k, int idx) {
		int nextPosition = -1;
		
		switch (idx) {
		case 0:
			if(position > 0) {
				nextPosition = position - 1;
			}
			break;
		case 1:
			if(position > 0 && position < k) {
				nextPosition = position * 2;
			}
			break;
		default:
			if(position < k) {
				nextPosition = position + 1;
			}
			break;
		}
		
		return nextPosition;
	}
	
	private static class Status {
		private int position;
		private int time;
		
		public Status(int position, int time) {
			this.position = position;
			this.time = time;
		}
		
		public int getPosition() {
			return position;
		}
		public int getTime() {
			return time;
		}
	}
}
