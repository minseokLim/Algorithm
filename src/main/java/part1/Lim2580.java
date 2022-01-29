package part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim2580 {
	private static List<Position> zeroPosition = new ArrayList<Position>();
	private static boolean allBreak = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] puzzle = new int[9][9];
		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 9; j++) {
				puzzle[i][j] = Integer.parseInt(st.nextToken());
				
				if(puzzle[i][j] == 0) {
					zeroPosition.add(new Position(i, j));
				}
			}
		}
		
		if(zeroPosition.size() == 0) {
			printAnswer(puzzle);
		} else {
			dfs(zeroPosition.get(0), puzzle, 0);
		}
	}
	
	private static void dfs(Position position, int[][] puzzle, int depth) {
				
		boolean[] occupied = getCandidates(position, puzzle);
		int i = position.getI();
		int j = position.getJ();
		
		for(int k = 1; k <= 9; k++) {
			
			if(allBreak) {
				break;				
			}
			
			if(!occupied[k]) {
				puzzle[i][j] = k;
				
				if(depth == zeroPosition.size() - 1) {
					printAnswer(puzzle);
					allBreak = true;
					return;
				}
				
				dfs(zeroPosition.get(depth + 1), puzzle, depth + 1);
				puzzle[i][j] = 0;
			}
		}
	}

	private static boolean[] getCandidates(Position position, int[][] puzzle) {
		boolean[] occupied = new boolean[10];
		int i = position.getI();
		int j = position.getJ();
		
		for(int k = 0; k < 9; k++) {
			occupied[puzzle[i][k]] = true;
			occupied[puzzle[k][j]] = true;
		}
		
		int iUnder = i / 3 * 3;
		int iUpper = i / 3 * 3 + 2;
		int jUnder = j / 3 * 3;
		int jUpper = j / 3 * 3 + 2;
		
		for(int k = iUnder; k <= iUpper; k++) {
			
			for(int h = jUnder; h <= jUpper; h++) {
				occupied[puzzle[k][h]] = true;
			}
		} 
		
		return occupied;
	}

	private static void printAnswer(int[][] puzzle) {
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 9; j++) {
				sb.append(puzzle[i][j] + " ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static class Position {
		private int i;
		private int j;
		
		public Position(int i, int j) {
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
