package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim9019 {
	private static char[] cmdChar = {'D', 'S', 'L', 'R'};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(a, b) + "\n");
		}
		
		System.out.println(sb);
	}

	private static String bfs(int a, int b) {
		boolean[] visited = new boolean[10000];
		visited[a] = true;
		Queue<Status> queue = new LinkedList<Status>();
		queue.offer(new Status("", a));
		
		while(!queue.isEmpty()) {
			Status poll = queue.poll();
			String cmd = poll.getCmd();
			int no = poll.getNo();
			
			if(no == b) {
				return cmd;
			}
			
			for(int i = 0; i < 4; i++) {
				int changedNo = process(no, cmdChar[i]);
				
				if(!visited[changedNo]) {
					visited[changedNo] = true;
					queue.offer(new Status(cmd + cmdChar[i], changedNo));
				}
			}
		}
		
		return null;
	}
	
	private static int process(int no, char c) {
		int ret = 0;
		int[] d = new int[4];
		
		if(c == 'L' || c == 'R') {
			for(int i = 0; i < 4; i++) {
				d[i] = no % 10;
				no /= 10;
			}
		}
		
		switch (c) {
		case 'D':
			ret = (2 * no) % 10000;
			break;
		case 'S':
			ret = no != 0 ? no - 1 : 9999;
			break;
		case 'L':
			ret = ((d[2] * 10 + d[1]) * 10 + d[0]) * 10 + d[3];
			break;
		case 'R':
			ret = ((d[0] * 10 + d[3]) * 10 + d[2]) * 10 + d[1];
			break;
		}
		
		return ret;
	}

	private static class Status {
		private String cmd;
		private int no;
		
		public Status(String cmd, int no) {
			this.cmd = cmd;
			this.no = no;
		}

		public String getCmd() {
			return cmd;
		}

		public int getNo() {
			return no;
		}
	}
}
