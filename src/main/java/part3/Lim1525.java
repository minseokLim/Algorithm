package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Lim1525 {
	private static int[] di = {-1, 1, 0, 0};
	private static int[] dj = {0, 0, -1, 1};
	private static final int PUZZLE_SIZE = 3;
	private static final int FLATTED_SIZE = PUZZLE_SIZE * PUZZLE_SIZE;
	private static boolean[][] canSwap = new boolean[FLATTED_SIZE][FLATTED_SIZE];
	
	static {
		for(int i = 0; i < PUZZLE_SIZE; i++) {
			for(int j = 0; j < PUZZLE_SIZE; j++) {
				for(int k = 0; k < 4; k++) {
					int nextI = i + di[k];
					int nextJ = j + dj[k];
					
					if(nextI >= 0 && nextJ >= 0 && nextI < PUZZLE_SIZE && nextJ < PUZZLE_SIZE) {
						canSwap[i * PUZZLE_SIZE + j][nextI * PUZZLE_SIZE + nextJ] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int initPuzzle = 0;
		int initZeroIdx = 0;
		
		for(int i = 0; i < PUZZLE_SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < PUZZLE_SIZE; j++) {
				int n = Integer.parseInt(st.nextToken());
				initPuzzle = initPuzzle * 10 + n;
				
				if(n == 0) {
					initZeroIdx = i * PUZZLE_SIZE + j;
				}
			}
		}
		
		int min = bfs(initPuzzle, initZeroIdx);
		
		System.out.println(min);
	}

	private static int bfs(int initPuzzle, int initZeroIdx) {
		Queue<Status> queue = new LinkedList<Status>();
		Set<Integer> visited = new HashSet<Integer>();
		
		queue.offer(new Status(initPuzzle, 0, initZeroIdx));
		visited.add(initPuzzle);
		
		while(!queue.isEmpty()) {
			Status poll = queue.poll();
			int puzzle = poll.getPuzzle();
			int times = poll.getTimes();
			int zeroIdx = poll.getZeroIdx();
			
			if(puzzle == 123456780) {
				return times;
			}

			for(int i = 0; i < FLATTED_SIZE; i++) {
				if(canSwap[zeroIdx][i]) {
					int next = swapNo(puzzle, zeroIdx, i);
					
					if(!visited.contains(next)) {
						queue.offer(new Status(next, times + 1, i));
						visited.add(next);
					}
				}
			}
		}
		
		return -1;
	}
	
	private static int swapNo(int puzzle, int zeroIdx, int nextIdx) {
		int x = extractNo(puzzle, nextIdx);
		
		puzzle -= x * power(10, FLATTED_SIZE - 1 - nextIdx);
		puzzle += x * power(10, FLATTED_SIZE - 1 - zeroIdx);
		
		return puzzle;
	}

	private static int extractNo(int puzzle, int idx) {
		return (puzzle / power(10, FLATTED_SIZE - 1 - idx)) % 10;	
	}
	
	private static int power(int a, int n) {
		int ret = 1;
		
		for(int i = 0; i < n; i++) {
			ret *= a;
		}
		
		return ret;
	}
	
	private static class Status {
		private int puzzle;
		private int times;
		private int zeroIdx;
		
		public Status(int puzzle, int times, int zeroIdx) {
			this.puzzle = puzzle;
			this.times = times;
			this.zeroIdx = zeroIdx;
		}

		public int getPuzzle() {
			return puzzle;
		}

		public int getTimes() {
			return times;
		}

		public int getZeroIdx() {
			return zeroIdx;
		}
	}
}
