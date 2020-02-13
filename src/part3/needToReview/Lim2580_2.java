package part3.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim2580_2 {
	private static boolean finished = false;
	private static boolean[][] checkI = new boolean[9][10];
	private static boolean[][] checkJ = new boolean[9][10];
	private static boolean[][][] checkBox = new boolean[3][3][10];
	
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
				} else {
					checkI[i][puzzle[i][j]] = true;
					checkJ[j][puzzle[i][j]] = true;
					checkBox[i / 3][j / 3][puzzle[i][j]] = true;
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
		
		int i = point.getI();
		int j = point.getJ();
		
		for(int k = 1; k <= 9; k++) {
			if(!checkI[i][k] && !checkJ[j][k] && !checkBox[i / 3][j / 3][k]) {
				
				puzzle[i][j] = k;
				checkI[i][k] = true;
				checkJ[j][k] = true;
				checkBox[i / 3][j / 3][k] = true;
				
				if(depth == zeroList.size() - 1) {
					printPuzzle(puzzle);
					finished = true;
					return;
				}
				
				dfs(zeroList.get(depth + 1), puzzle, zeroList, depth + 1);			
				puzzle[i][j] = 0;
				checkI[i][k] = false;
				checkJ[j][k] = false;
				checkBox[i / 3][j / 3][k] = false;
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
