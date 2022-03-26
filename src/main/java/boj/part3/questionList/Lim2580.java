package boj.part3.questionList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim2580 {
	private static List<Point> zeroList = new ArrayList<Point>();
	private static boolean finished = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] puzzle = new int[9][9];
		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 9; j++) {
				puzzle[i][j] = Integer.parseInt(st.nextToken());
				
				if(puzzle[i][j] == 0) {
					zeroList.add(new Point(i, j));
				}
			}
		}
		
		if(zeroList.isEmpty()) {
			printPuzzle(puzzle);
		} else {
			dfs(zeroList.get(0), puzzle, 0);
		}
	}
	
	private static void dfs(Point point, int[][] puzzle, int depth) {
		if(finished) {
			return;
		}
		
		boolean[] candidates = getCandidates(point, puzzle);
		int i = point.getI();
		int j = point.getJ();
		
		for(int k = 1; k <= 9; k++) {
			
			if(!candidates[k]) {
				puzzle[i][j] = k;
				
				if(depth == zeroList.size() - 1) {
					finished = true;
					printPuzzle(puzzle);
					return;
				}
				
				dfs(zeroList.get(depth + 1), puzzle, depth + 1);
				puzzle[i][j] = 0;
			}
		}
	}

	private static void printPuzzle(int[][] puzzle) {
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(puzzle[i][j] + " ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static boolean[] getCandidates(Point point, int[][] puzzle) {
		int i = point.getI();
		int j = point.getJ();
		
		boolean[] candidates = new boolean[10];
		
		int sI = i / 3 * 3;
		int sJ = j / 3 * 3;
		int eI = sI + 3;
		int eJ = sJ + 3;
		
		for(int k = 0; k < 9; k++) {
			candidates[puzzle[i][k]] = true;
			candidates[puzzle[k][j]] = true;
		}
		
		for(int k = sI; k < eI; k++) {
			for(int h = sJ; h < eJ; h++) {
				candidates[puzzle[k][h]] = true;
			}
		}
		
		return candidates;
	}
	
	private static class Point {
		private int i;
		private int j;
		
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public int getJ() {
			return j;
		}
	}
}
