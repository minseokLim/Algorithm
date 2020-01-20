package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Lim1261 {
	private static int[] di = {1, 0, -1, 0};
	private static int[] dj = {0, 1, 0, -1};
	private static int m;
	private static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		boolean[][] maze = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			char[] temp = br.readLine().toCharArray();
			
			for(int j = 0; j < m; j++) {
				maze[i][j] = temp[j] == '0' ? true : false;
			}
		}
		
		boolean[][] visited = new boolean[n][m];
		int[][] dp = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		dp[n - 1][m - 1] = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dp[i][j] = dfs(maze, visited, dp, i, j);
			}
		}
				
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
		System.out.println(dp[0][0]);
	}

	private static int dfs(boolean[][] maze, boolean[][] visited, int[][] dp, int i, int j) {
		visited[i][j] = true;
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int min = -1;
		
		for(int k = 0; k < 4; k++) {
			int nextI = i + di[k];
			int nextJ = j + dj[k];
			
			if(nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m && !visited[nextI][nextJ]) {
				int tmp;
				
				if(maze[nextI][nextJ]) {
					tmp = dfs(maze, visited, dp, nextI, nextJ);
				} else {
					tmp = dfs(maze, visited, dp, nextI, nextJ) + 1;
				}
				
				if(min == -1 || tmp < min) {
					min = tmp;
				}
				
				visited[nextI][nextJ] = false;
			}
		}
		
		return min;
	}
}
