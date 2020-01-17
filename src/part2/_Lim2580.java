package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _Lim2580 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] puzzle = new int[9][9];
		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 9; j++) {
				puzzle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		@SuppressWarnings("unchecked")
		List<Integer>[][] lists = new ArrayList[9][9];
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {			
				if(puzzle[i][j] == 0) {
					solve1(puzzle, lists, i, j);
				}
			}
		}
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(puzzle[i][j] == 0) {
					solve2(puzzle, lists, i, j);
				}
			}
		}
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(puzzle[i][j] == 0) {
					solve3(puzzle, lists, i, j);
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(puzzle[i][j] + " ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void solve3(int[][] puzzle, List<Integer>[][] lists, int i, int j) {
		int sI = (i / 3) * 3;
		int sJ = (j / 3) * 3;
		int eI = sI + 3;
		int eJ = sJ + 3;
		
		boolean[] check = new boolean[10];
		
		for(int k = 0; k < 9; k++) {
			check[puzzle[i][k]] = true;
			check[puzzle[k][j]] = true;
		}
		
		for(int k = sI; k < eI; k++) {
			for(int h = sJ; h < eJ; h++) {
				check[puzzle[k][h]] = true;
			}
		}
				
		for(int k = 1; k <= 9; k++) {
			if(!check[k]) {
				puzzle[i][j] = k;
				break;
			}
		}
	}

	private static void solve2(int[][] puzzle, List<Integer>[][] lists, int i, int j) {
		int sI = (i / 3) * 3;
		int sJ = (j / 3) * 3;
		int eI = sI + 3;
		int eJ = sJ + 3;
		
		for(int k = 0; k < 9; k++) {
			if(puzzle[i][k] == 0 && k != j) {
				for(Integer elem : lists[i][k]) {
					lists[i][j].remove(elem);
					
					if(lists[i][j].size() == 0) {
						return;
					}
				}
			}
			
			if(puzzle[k][j] == 0 && k != i) {
				for(Integer elem : lists[k][j]) {
					lists[i][j].remove(elem);
					
					if(lists[i][j].size() == 0) {
						return;
					}
				}
			}
		}
		
		for(int k = sI; k < eI; k++) {
			for(int h = sJ; h < eJ; h++) {
				if(puzzle[k][h] == 0 && k != i && h != j) {
					for(Integer elem : lists[k][h]) {
						lists[i][j].remove(elem);
						
						if(lists[i][j].size() == 0) {
							return;
						}
					}
				}				
			}
		}
		
		if(lists[i][j].size() == 1) {
			puzzle[i][j] = lists[i][j].get(0);
		}
	}

	private static void solve1(int[][] puzzle, List<Integer>[][] lists, int i, int j) {
		int sI = (i / 3) * 3;
		int sJ = (j / 3) * 3;
		int eI = sI + 3;
		int eJ = sJ + 3;
		
		boolean[] check = new boolean[10];
		
		for(int k = 0; k < 9; k++) {
			check[puzzle[i][k]] = true;
			check[puzzle[k][j]] = true;
		}
		
		for(int k = sI; k < eI; k++) {
			for(int h = sJ; h < eJ; h++) {
				check[puzzle[k][h]] = true;
			}
		}
		
		List<Integer> cands = new ArrayList<Integer>();
		
		for(int k = 1; k <= 9; k++) {
			if(!check[k]) {
				cands.add(k);
			}
		}
		
		if(cands.size() == 1) {
			puzzle[i][j] = cands.get(0);
		} else {
			lists[i][j] = cands;
		}
	}
}
