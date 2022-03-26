package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2133 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n % 2 != 0) {
			System.out.println(0);
			return;
		}
		
		n /= 2;
		
		long[] dp = new long[n + 1];
		
		dp[0] = 1;
		dp[1] = 3;
		
		for(int i = 2; i <= n; i++) {		
			for(int j = 0; j < i - 1; j++) {
				dp[i] += 2 * dp[j];
			}
			
			dp[i] += 3 * dp[i - 1];
		}
		
		System.out.println(dp[n]);
	}
}
