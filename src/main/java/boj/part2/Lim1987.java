package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1987 {
	private static int[] di = {-1, 1, 0, 0};
	private static int[] dj = {0, 0, 1, -1};
	private static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			
			for(int j = 0; j < c; j++) {
				board[i][j] = temp[j] - 'A';
			}
		}
		
		boolean[] visited = new boolean['Z' - 'A' + 1];
		
		dfs(board, visited, r, c, 0, 0, 1);
		
		System.out.println(max);
	}

	private static void dfs(int[][] board, boolean[] visited, int r, int c, int i, int j, int depth) {
		visited[board[i][j]] = true;
		
		if(depth > max) {
			max = depth;
		}
		
		for(int k = 0; k < 4; k++) {
			int nextI = i + di[k];
			int nextJ = j + dj[k];
			
			if(nextI >= 0 && nextI < r && nextJ >= 0 && nextJ < c && !visited[board[nextI][nextJ]]) {
				dfs(board, visited, r, c, nextI, nextJ, depth + 1);
				visited[board[nextI][nextJ]] = false;
			}
		}
	}
}
