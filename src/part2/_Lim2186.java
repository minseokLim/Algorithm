package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Lim2186 {
	private static int[] di = {-1, 1, 0, 0};
	private static int[] dj = {0, 0, 1, -1};
	private static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		char[][] input = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		char[] answer = br.readLine().toCharArray();
		int size = answer.length;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(input[i][j] == answer[0]) {
					dfs(input, answer, k, 1, size, i, j, n, m);
				}
			}
		}
		
		System.out.println(cnt);
	}

	private static void dfs(char[][] input, char[] answer, int k, int depth, int size, int i, int j, int n, int m) {
		if(depth == size) {
			cnt++;
			return;
		}
		
		for(int l = 1; l <= k; l++) {
			for(int h = 0; h < 4; h++) {
				int newI = i + di[h] * l;
				int newJ = j + dj[h] * l;
				
				if(newI >= 0 && newI < n && newJ >= 0 && newJ < m && input[newI][newJ] == answer[depth]) {
					dfs(input, answer, k, depth + 1, size, newI, newJ, n, m);
				}
			}
		}
	}
}
