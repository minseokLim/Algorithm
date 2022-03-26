package boj.part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Lim1525_2 {
	private static int[] di = {-1, 1, 0, 0};
	private static int[] dj = {0, 0, -1, 1};
	private static int PUZZLE_SIZE = 3;
	private static final int FLATTED_SIZE = PUZZLE_SIZE * PUZZLE_SIZE;
	private static boolean[][] canChange = new boolean[FLATTED_SIZE][FLATTED_SIZE];
	
	static {
		for(int i = 0; i < PUZZLE_SIZE; i++) {
			for(int j = 0; j < PUZZLE_SIZE; j++) {
				for(int k = 0; k < 4; k++) {
					int newI = i + di[k];
					int newJ = j + dj[k];
					
					if(newI >= 0 && newI < PUZZLE_SIZE && newJ >= 0 && newJ < PUZZLE_SIZE) {
						canChange[i * PUZZLE_SIZE + j][newI * PUZZLE_SIZE + newJ] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initPuz = 0;
		int zeroIdx = 0;
		
		for(int i = 0; i < PUZZLE_SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < PUZZLE_SIZE; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				initPuz = initPuz * 10 + n;
				
				if(n == 0) {
					zeroIdx = i * PUZZLE_SIZE + j;
				}
			}
		}
		
		int min = bfs(initPuz, zeroIdx);
		
		System.out.println(min);
	}
	
	private static int bfs(int initPuz, int initZIdx) {
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(initPuz);
		Queue<PuzStatus> queue = new LinkedList<PuzStatus>();
		queue.offer(new PuzStatus(initPuz, initZIdx, 0));
		int min = -1;
		
		while(!queue.isEmpty()) {
			PuzStatus poll = queue.poll();
			int puzzle = poll.getPuzzle();
			int zeroIdx = poll.getZeroIdx();
			int time = poll.getTime();
			
			if(puzzle == 123456780) {
				min = time;
				break;
			}
			
			for(int i = 0; i < FLATTED_SIZE; i++) {
				if(canChange[zeroIdx][i]) {
					int newPuz = swapValue(puzzle, zeroIdx, i);
					
					if(!visited.contains(newPuz)) {
						visited.add(newPuz);
						queue.offer(new PuzStatus(newPuz, i, time + 1));
					}
				}
			}
		}
				
		return min;
	}
	
	private static int swapValue(int puzzle, int zeroIdx, int newZIdx) {
		int a = (puzzle / power(10, FLATTED_SIZE - newZIdx - 1)) % 10;
		puzzle -= a * power(10, FLATTED_SIZE - newZIdx - 1);
		puzzle += a * power(10, FLATTED_SIZE - zeroIdx - 1);
		return puzzle;
	}
	
	private static int power(int a, int n) {
		int ret = 1;
		
		for(int i = 0; i < n; i++) {
			ret *= a;
		}
		
		return ret;
	}

	private static class PuzStatus {
		private int puzzle;
		private int zeroIdx;
		private int time;
		
		public PuzStatus(int puzzle, int zeroIdx, int time) {
			this.puzzle = puzzle;
			this.zeroIdx = zeroIdx;
			this.time = time;
		}

		public int getPuzzle() {
			return puzzle;
		}

		public int getZeroIdx() {
			return zeroIdx;
		}

		public int getTime() {
			return time;
		}
	}
}
