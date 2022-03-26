package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim9019 {
	private static char[] cmds = {'D', 'S', 'L', 'R'};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer answer = new StringBuffer();
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			answer.append(bfs(a, b) + "\n");
		}
		
		System.out.println(answer);
	}
	
	private static String bfs(int a, int b) {
		String answer = null;
		
		boolean[] visited = new boolean[10000];
		Queue<CalInfo> queue = new LinkedList<CalInfo>();
		visited[a] = true;
		queue.add(new CalInfo(a, ""));
		
		while(!queue.isEmpty()) {
			CalInfo poll = queue.poll();			
			int curNo = poll.getCurNo();
			String cmd = poll.getCmd();
			
			if(curNo == b) {
				answer = cmd;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nextNo = transform(cmds[i], curNo);
				
				if(!visited[nextNo]) {
					visited[nextNo] = true;
					queue.add(new CalInfo(nextNo, cmd + cmds[i]));
				}				
			}
		}
		
		return answer;
	}

	private static class CalInfo {
		private int curNo;
		private String cmd;
		
		public CalInfo(int curNo, String cmd) {
			this.curNo = curNo;
			this.cmd = cmd;
		}

		public int getCurNo() {
			return curNo;
		}

		public String getCmd() {
			return cmd;
		}
	}
	
	private static int transform(char type, int n) {
		int answer;
		int[] d;
		
		switch (type) {
		case 'D':
			answer = (2 * n) % 10000;
			break;
		case 'S':
			if(n == 0) {
				answer = 9999;
			} else {
				answer = n - 1;
			}
			break;
		case 'L':
			d = new int[4];
			
			for(int i = 3; i >= 0; i--) {
				d[i] = n % 10;
				n /= 10;
			}
			
			answer = d[1] * 1000 + d[2] * 100 + d[3] * 10 + d[0];
			break;
		default:
			d = new int[4];
			
			for(int i = 3; i >= 0; i--) {
				d[i] = n % 10;
				n /= 10;
			}
			
			answer = d[3] * 1000 + d[0] * 100 + d[1] * 10 + d[2];
			break;
		}
		
		return answer;
	}
}
