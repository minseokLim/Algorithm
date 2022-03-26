package boj.part2;

// https://compasstree934.tistory.com/13
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim2225_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n + 1][k + 1];
		
		for(int i = 1; i <= k; i++) {
			dp[0][i] = 1;
//			dp[1][i] = i;
		}
		
		for(int i = 0; i <= n; i++) {
			dp[i][1] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 2; j <= k; j++) {
				for(int h = 0; h <= i; h++) {
					dp[i][j] += dp[h][j - 1];
					dp[i][j] %= 1_000_000_000;
				}				
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
