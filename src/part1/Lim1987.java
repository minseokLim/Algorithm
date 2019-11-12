package part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1987 {
	private static int[] di = {-1, 1, 0, 0};
	private static int[] dj = {0, 0, -1, 1};
	private static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int R = Integer.parseInt(st.nextToken());
		final int C = Integer.parseInt(st.nextToken());
		char[][] board = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		boolean[] visited = new boolean[26];
		visited[board[0][0] - 65] = true;
		dfs(0, 0, board, visited, 1, R, C);
		
		System.out.println(max);
	}

	
	private static void dfs(int i, int j, char[][] board, boolean[] visited, int cnt, int r, int c) {
				
		if(cnt > max) {
			max = cnt;
		}
		
		for(int k = 0; k < 4; k++) {
			
			int nextI = i + di[k];
			int nextJ = j + dj[k];
			
			if(nextI >= 0 && nextI < r && nextJ >= 0 && nextJ < c && !visited[board[nextI][nextJ] - 65]) {
				visited[board[nextI][nextJ] - 65] = true;
				dfs(nextI, nextJ, board, visited, cnt + 1, r, c);
				visited[board[nextI][nextJ] - 65] = false;
			}
		}
	}
}
