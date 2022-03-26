package boj.part2.needToReview;

// https://compasstree934.tistory.com/13
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim2225_3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n + 1][k + 1];
		
		for(int i = 1; i <= k; i++) {
			dp[1][i] = i;
		}
		
		for(int i = 1; i <= n; i++) {
			dp[i][1] = 1;
		}
		// dp[i - 1][j] 는 i - 1보다 작은 수에 대한 j - 1에 대한 합이 이루어 졌다고 가정하는 것이다
		for(int i = 2; i <= n; i++) {
			for(int j = 2; j <= k; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_000;			
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
