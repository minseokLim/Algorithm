package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim2186 {
	private static int[] di = {-1, 1, 0, 0};
	private static int[] dj = {0, 0, -1, 1};
	private static int n;
	private static int m;
	private static int k;
	private static int trgtLen;
	private static int[][][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		char[] goal = br.readLine().toCharArray();
		trgtLen = goal.length;
		dp = new int[n][m][trgtLen];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {				
				if(board[i][j] == goal[0]) {
					cnt += dfs(board, goal, i, j, 0);
				}
			}
		}
		
		System.out.println(cnt);
	}

	private static int dfs(char[][] board, char[] goal, int i, int j, int depth) {
		
		if(dp[i][j][depth] != -1) {
			return dp[i][j][depth];
		}
		
		if(depth == trgtLen - 1) {
			return 1;
		}
		
		int cnt = 0;
		
		for(int a = 1; a <= k; a++) {
			for(int b = 0; b < 4; b++) {
				int nextI = i + di[b] * a;
				int nextJ = j + dj[b] * a;
				
				if(nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < m && board[nextI][nextJ] == goal[depth + 1]) {
					cnt += dfs(board, goal, nextI, nextJ, depth + 1);
				}
			}
		}
		
		return dp[i][j][depth] = cnt;
	}
}
