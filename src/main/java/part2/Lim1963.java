package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim1963 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int min = bfs(a, b);
			
			if(min != -1) {
				sb.append(min + "\n");
			} else {
				sb.append("Impossible\n");
			}
		}
		
		System.out.println(sb);
	}
	
	private static int bfs(int a, int b) {
		int min = -1;
		boolean[] visited = new boolean[10000];
		visited[a] = true;
		Queue<Pw> queue = new LinkedList<Pw>();
		queue.offer(new Pw(a, 0));
		
		while(!queue.isEmpty()) {
			Pw poll = queue.poll();
			int pw = poll.getPw();
			int time = poll.getTime();
			
			if(pw == b) {
				min = time;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int init = initiateVal(pw, i);
				
				for(int j = 0; j <= 9; j++) {
					int nextPw = changePw(init, i, j);
					
					if(!visited[nextPw] && nextPw >= 1000 && isPrime(nextPw)) {
						visited[nextPw] = true;
						queue.offer(new Pw(nextPw, time + 1));
					}
				}
			}
		}
				
		return min;
	}
		
	private static int initiateVal(int pw, int i) {
		int n = (pw / power(10, i)) % 10;
		return pw - n * power(10, i);
	}
	
	private static int power(int value, int n) {
		int ret = 1;
		
		for(int i = 0; i < n; i++) {
			ret *= value;
		}
		
		return ret;
	}
	
	private static int changePw(int init, int i, int j) {
		return init + power(10, i) * j;
	}
	
	private static class Pw {
		private int pw;
		private int time;

		public Pw(int pw, int time) {
			this.pw = pw;
			this.time = time;
		}

		public int getPw() {
			return pw;
		}

		public int getTime() {
			return time;
		}
	}

	private static boolean isPrime(int n) {
		boolean ret = true;
		
		for(int i = 2; i < n; i++) {
			if(i * i > n) {
				break;
			}
			
			if(n % i == 0) {
				ret = false;
				break;
			}
		}
		
		return ret;
	}
}
