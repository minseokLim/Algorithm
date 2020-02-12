package part3.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim2580 {
	private static boolean finished = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] puzzle = new int[9][9];
		List<Point> zeroList = new ArrayList<Point>();
		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 9; j++) {
				puzzle[i][j] = Integer.parseInt(st.nextToken());
				
				if(puzzle[i][j] == 0) {
					zeroList.add(new Point(i, j));
				}
			}
		}
		
		if(zeroList.size() > 0) {
			dfs(zeroList.get(0), puzzle, zeroList, 0);
		} else {
			printPuzzle(puzzle);
		}	
	}

	private static void dfs(Point point, int[][] puzzle, List<Point> zeroList, int depth) {
		if(finished) {
			return;
		}
		
		boolean[] checked = getCandidates(puzzle, point);
		
		for(int k = 1; k <= 9; k++) {
			if(!checked[k]) {
				int i = point.getI();
				int j = point.getJ();
				
				puzzle[i][j] = k;
				
				if(depth == zeroList.size() - 1) {
					printPuzzle(puzzle);
					finished = true;
					return;
				}
				
				dfs(zeroList.get(depth + 1), puzzle, zeroList, depth + 1);			
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
	
	private static boolean[] getCandidates(int[][] puzzle, Point point) {
		int i = point.getI();
		int j = point.getJ();
		boolean[] checked = new boolean[10];
		
		for(int k = 0; k < 9; k++) {
			checked[puzzle[i][k]] = true;
		}
		
		for(int k = 0; k < 9; k++) {
			checked[puzzle[k][j]] = true;
		}
		
		int sI = i - i % 3;
		int sJ = j - j % 3;
		
		for(int k = sI; k < sI + 3; k++) {
			for(int h = sJ; h < sJ + 3; h++) {
				checked[puzzle[k][h]] = true;
			}
		}
		
		return checked;
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
