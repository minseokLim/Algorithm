package part3.questionList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim2186 {
	private static int[] di = {-1, 1, 0, 0};
	private static int[] dj = {0, 0, 1, -1};
	private static int n;
	private static int m;
	private static int k;
	private static int[][][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		char[][] input = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		char[] target = br.readLine().toCharArray();
		dp = new int[n][m][target.length];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(input[i][j] == target[0]) {
					cnt += dfs(input, target, i, j, 0);
				}
			}
		}
		
		System.out.println(cnt);
	}

	private static int dfs(char[][] input, char[] target, int i, int j, int depth) {
		if(depth == target.length - 1) {
			return dp[i][j][depth] = 1;
		}
		
		if(dp[i][j][depth] != -1) {
			return dp[i][j][depth];
		}
		
		int ret = 0;
		
		for(int l = 1; l <= k; l++) {
			for(int h = 0; h < 4; h++) {
				int newI = i + di[h] * l;
				int newJ = j + dj[h] * l;
				
				if(newI >= 0 && newI < n && newJ >= 0 && newJ < m && input[newI][newJ] == target[depth + 1]) {
					ret += dfs(input, target, newI, newJ, depth + 1);
				}
			}
		}
		
		return dp[i][j][depth] = ret;
	}
}
