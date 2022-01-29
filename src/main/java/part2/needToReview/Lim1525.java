package part2.needToReview;

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
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] puzzle = new int[3][3];
		int zeroI = 0;
		int zeroJ = 0;
		
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 3; j++) {
				puzzle[i][j] = Integer.parseInt(st.nextToken());
				
				if(puzzle[i][j] == 0) {
					zeroI = i;
					zeroJ = j;
				}
			}
		}
		
		int min = bfs(puzzle, zeroI, zeroJ);
		
		System.out.println(min);
	}
	
	private static int bfs(int[][] initPuz, int initZI, int initZJ) {
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(arrToInt(initPuz));
		Queue<PuzStatus> queue = new LinkedList<PuzStatus>();
		queue.offer(new PuzStatus(initZI, initZJ, initPuz, 0));
		int min = -1;
		
		while(!queue.isEmpty()) {
			PuzStatus poll = queue.poll();
			int zeroI = poll.getZeroI();
			int zeroJ = poll.getZeroJ();
			int[][] puzzle = poll.getPuzzle();
			int time = poll.getTime();
					
			if(arrToInt(puzzle) == 123456780) {
				min = time;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int newZI = zeroI + di[i];
				int newZJ = zeroJ + dj[i];
				
				if(newZI >= 0 && newZI < 3 && newZJ >= 0 && newZJ < 3) {
					int[][] newPuz = deepCopyArr(puzzle);
					newPuz[zeroI][zeroJ] = newPuz[newZI][newZJ];
					newPuz[newZI][newZJ] = 0;
					
					int newPuzInt = arrToInt(newPuz);
					
					if(!visited.contains(newPuzInt)) {
						visited.add(newPuzInt);
						queue.offer(new PuzStatus(newZI, newZJ, newPuz, time + 1));
					}
				}
			}
		}
		
		return min;
	}
	
	private static int arrToInt(int[][] arr) {
		int ret = 0;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				ret = ret * 10 + arr[i][j];
			}
		}
		
		return ret;
	}

	private static int[][] deepCopyArr(int[][] arr) {
		int[][] ret = new int[3][3];
		
		for(int i = 0; i < 3; i++) {
			System.arraycopy(arr[i], 0, ret[i], 0, 3);
		}
		
		return ret;
	}
	
	private static class PuzStatus {
		private int zeroI;
		private int zeroJ;
		private int[][] puzzle;
		private int time;
		
		public PuzStatus(int zeroI, int zeroJ, int[][] puzzle, int time) {
			this.zeroI = zeroI;
			this.zeroJ = zeroJ;
			this.puzzle = puzzle;
			this.time = time;
		}
		public int getZeroI() {
			return zeroI;
		}
		public int getZeroJ() {
			return zeroJ;
		}
		public int[][] getPuzzle() {
			return puzzle;
		}
		public int getTime() {
			return time;
		}
	}
}
