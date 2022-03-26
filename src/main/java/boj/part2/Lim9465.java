package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim9465 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] scores = new int[2][n];
			
			for(int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int k = 0; k < n; k++) {
					scores[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = solve(scores, n);
			sb.append(max + "\n");
		}
		
		System.out.println(sb);
	}

	private static int solve(int[][] scores, int n) {
		
		int[][] ans = new int[3][n];
		ans[0][0] = scores[0][0];
		ans[1][0] = scores[1][0];
		ans[2][0] = 0;
		
		for(int i = 1; i < n; i++) {
			ans[0][i] = Math.max(ans[1][i - 1], ans[2][i - 1]) + scores[0][i];
			ans[1][i] = Math.max(ans[0][i - 1], ans[2][i - 1]) + scores[1][i];
			ans[2][i] = Math.max(ans[0][i - 1], ans[1][i - 1]);
		}
		
		return Math.max(ans[0][n - 1], ans[1][n - 1]);
	}
}
