package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Lim1261_2 {
	private static int[] di = {-1, 1, 0, 0};
	private static int[] dj = {0, 0, -1, 1};
	private static int min = Integer.MAX_VALUE;
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
		
		dfs(maze, visited, 0, 0, 0);
		
		System.out.println(min);
	}

	private static void dfs(boolean[][] maze, boolean[][] visited, int i, int j, int cnt) {
		visited[i][j] = true;
		
		if(cnt >= min) {
			return;
		}
		
		if(i == n - 1 && j == m - 1) {
			if(cnt < min) {
				min = cnt;
			}
			
			return;
		}
		
		for(int k = 0; k < 4; k++) {
			int nextI = i + di[k];
			int nextJ = j + dj[k];
			
			if(nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m && !visited[nextI][nextJ]) {
				if(maze[nextI][nextJ]) {
					dfs(maze, visited, nextI, nextJ, cnt);
				} else {
					dfs(maze, visited, nextI, nextJ, cnt + 1);
				}
				
				visited[nextI][nextJ] = false;
			}
		}
	}
}
