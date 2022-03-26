package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Lim1525 {
	private static final int PUZZLE_SIZE = 3;
	private static final int FLATTED_PUZZLE_SIZE = PUZZLE_SIZE * PUZZLE_SIZE;
	private static final int DESTINATION = 123456780;
	private static final boolean[][] matrix = new boolean[FLATTED_PUZZLE_SIZE][FLATTED_PUZZLE_SIZE];
	private static int[] di = {-1, 0, 1, 0};
	private static int[] dj = {0, 1, 0, -1};
	
	static {
		
		for(int i = 0; i < FLATTED_PUZZLE_SIZE; i++) {
			int pI = i / PUZZLE_SIZE;
			int pJ = i % PUZZLE_SIZE;
			
			for(int j = 0; j < 4; j++) {
				
				int trgtI = pI + di[j];
				int trgtJ = pJ + dj[j];
				
				if(trgtI >= 0 && trgtI < PUZZLE_SIZE && trgtJ >= 0 && trgtJ < PUZZLE_SIZE) {
					matrix[i][trgtI * PUZZLE_SIZE + trgtJ] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initStatus = 0;
		int zeroIdx = -1;
		
		for(int i = 0; i < PUZZLE_SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(byte j = 0; j < PUZZLE_SIZE; j++) {
				int no = Integer.parseInt(st.nextToken());
				initStatus = initStatus * 10 + no;
				
				if(no == 0) {
					zeroIdx = i * PUZZLE_SIZE + j;
				}
			}
		}
		
		int answer = bfs(initStatus, zeroIdx);
		
		System.out.println(answer);
		
	}

	private static int bfs(int initStatus, int initZeroIdx) {
		int answer = -1;
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(initStatus);
		Queue<Puzzle> queue = new LinkedList<Puzzle>();
		queue.add(new Puzzle(initStatus, initZeroIdx, 0));
		
		while(!queue.isEmpty()) {
			Puzzle poll = queue.poll();
			int status = poll.getStatus();
			int zeroIdx = poll.getZeroIdx();
			int cnt = poll.getCnt();
			
			if(status == DESTINATION) {
				answer = cnt;
				break;
			}
			
			for(int i = 0; i < FLATTED_PUZZLE_SIZE; i++) {
				
				if(matrix[zeroIdx][i]) {
					
					int nextStatus = swapNumbers(status, zeroIdx, i);
					
					if(!visited.contains(nextStatus)) {
						visited.add(nextStatus);
						queue.add(new Puzzle(nextStatus, i, cnt + 1));
					}
				}
			}
		}
		
		return answer;
	}
	
	private static int swapNumbers(int status, int zeroIdx, int i) {
		int a = extractNo(status, FLATTED_PUZZLE_SIZE - zeroIdx - 1);
		int b = extractNo(status, FLATTED_PUZZLE_SIZE - i - 1);
		int ret = status - (a * tenPower(FLATTED_PUZZLE_SIZE - zeroIdx - 1) + b * tenPower(FLATTED_PUZZLE_SIZE - i - 1));
		ret += a * tenPower(FLATTED_PUZZLE_SIZE - i - 1) + b * tenPower(FLATTED_PUZZLE_SIZE - zeroIdx - 1);
		
		return ret;
	}

	private static int extractNo(int number, int m) {
		int temp = number / tenPower(m);
		
		return temp % 10;
	}
	
	private static int tenPower(int n) {
		int ret = 1;
		
		for(int i = 0; i < n; i++) {
			ret *= 10;
		}
		
		return ret;
	}

	private static class Puzzle {
		private int status;
		private int zeroIdx;
		private int cnt;
		
		public Puzzle(int status, int zeroIdx, int cnt) {
			this.status = status;
			this.zeroIdx = zeroIdx;
			this.cnt = cnt;
		}

		public int getStatus() {
			return status;
		}

		public int getZeroIdx() {
			return zeroIdx;
		}

		public int getCnt() {
			return cnt;
		}
	}
}
