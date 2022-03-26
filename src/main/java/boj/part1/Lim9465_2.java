package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim9465_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] scores = new int[2][n + 1];
			int[][] dp = new int[2][n + 1];
			
			StringTokenizer st;
			
			for(int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				
				for(int k = 1; k < n + 1; k++) {
					scores[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = scores[0][1];
			dp[1][1] = scores[1][1];
			
			if(n > 1) {
				for(int j = 2; j < n + 1; j++) {
					dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + scores[0][j];
					dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + scores[1][j];
				}
			}
			
			sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
		}
		
		System.out.println(sb);
	}
}
