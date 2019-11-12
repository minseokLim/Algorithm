package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim1963 {
	private static List<Integer> primeNumbers = new ArrayList<Integer>();
	private static boolean[] isPrime = new boolean[10000];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		getPrimeNumbers(10000);
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < tCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int min = bfs(start, end);
			
			if(min == -1) {
				sb.append("Impossible\n");
			} else {
				sb.append(min + "\n");
			}
		}			
		
		System.out.println(sb);
	}

	private static int bfs(int start, int end) {
		int answer = -1;
		boolean[] visited = new boolean[10000];
		
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(new Pair(start, 0));
		
		while(!queue.isEmpty()) {
			Pair poll = queue.poll();
			int num = poll.getNum();
			int cnt = poll.getCnt();
			
			if(num == end) {
				answer = cnt;
				break;
			}
			
			if(visited[num]) {
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 10; j++) {
					
					int tNum = changeNum(num, i, j);
					
					if(tNum >= 1000 && isPrime[tNum]) {
						visited[num] = true;
						queue.offer(new Pair(tNum, cnt + 1));
					}
				}
			}
		}
		
		return answer;
	}
	
	private static class Pair {
		private int num;
		private int cnt;
		
		public Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		public int getNum() {
			return num;
		}

		public int getCnt() {
			return cnt;
		}
	}
	
	private static int changeNum(int num, int changeIdx, int changeNo) {
		int[] nums = new int[4];
		int ret = 0;
		for(int i = 0; i < 4; i++) {
			nums[i] = num % 10;
			num /= 10;
		}
		
		nums[changeIdx] = changeNo;
		
		for(int i = 3; i >= 0; i--) {
			ret = ret * 10 + nums[i];
		}
		
		return ret;
	}

	private static void getPrimeNumbers(int n) {
		primeNumbers.add(2);
		
		for(int i = 3; i < n; i++) {
			
			if(checkIfPrime(i)) {
				primeNumbers.add(i);
				isPrime[i] = true;
			}
		}
	}
	
	private static boolean checkIfPrime(int n) {
		
		if(n <= 1) {
			return false;
		}
		
		boolean answer = true;
		
		for(int prime : primeNumbers) {
			
			if(prime * prime > n) {
				break;			
			}
			
			if(n % prime == 0) {
				answer = false;
			}
		}
		
		return answer;
	}
}
