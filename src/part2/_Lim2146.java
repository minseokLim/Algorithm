package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Lim2146 {
	private static int[] di = {1, -1, 0, 0};
	private static int[] dj = {0, 0, 1, -1};
	private static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		boolean[][] isIsland = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				if("1".equals(st.nextToken())) {
					isIsland[i][j] = true;
				}
			}
		}
		
		boolean[][] visited = new boolean[N][N];
		int[][] map = new int[N][N];
		int color = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(isIsland[i][j] && !visited[i][j]) {
					dfs(isIsland, visited, map, i, j, ++color, N);
				}
			}
		}
		
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(isIsland[i][j] && !visited[i][j]) {
					
				}
			}
		}
	}

	private static void dfs(boolean[][] isIsland, boolean[][] visited, int[][] map, int i, int j, int color, int n) {
		visited[i][j] = true;
		map[i][j] = color;
		
		for(int k = 0; k < 4; k++) {
			int nextI = i + di[k];
			int nextJ = j + dj[k];
			
			if(nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < n) {
				if(isIsland[nextI][nextJ] && !visited[nextI][nextJ]) {
					dfs(isIsland, visited, map, nextI, nextJ, color, n);
				}
			}
		}
	}
}
