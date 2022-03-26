package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim2186 {
	static int n;
	static int m;
	static int k;
	static char[][] map;
	static char[] targetArr;
	static int targetLength;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		targetArr = br.readLine().toCharArray();
		targetLength = targetArr.length;
		char startChar = targetArr[0];
		dp = new int[n][m][targetLength];
		
		// dp[i][j][seq] 값이 0으로서 저장이 되는 경우도 있기 때문에, -1을 초기값으로 하지 않으면 0이 저장되는 경우와 초기값과의 구분을 할 수 없게 된다.
		// 따라서 초기값을 -1로 하는 것이 중복되는 연산을 줄일 수 있는 방법이다.
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
		
		int cnt = 0;
				
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				
				if(map[i][j] == startChar) {
					cnt += dfs(i, j, 0);
				}
			}
		}	
		
		System.out.println(cnt);
	}
	
	private static int dfs(int i, int j, int seq) {
		
		int ret = 0;
		
		if(seq == targetLength - 1) {		
			return dp[i][j][seq] = 1;
		}
		
		if(dp[i][j][seq] != -1) {
			return dp[i][j][seq];
		}
		
		for(int h = 1; h <= k; h++) {
			
			for(int l = 0; l < 4; l++) {
				int nextI = i + di[l] * h;
				int nextJ = j + dj[l] * h;
				
				if(nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m && map[nextI][nextJ] == targetArr[seq + 1]) {
					ret += dfs(nextI, nextJ, seq + 1);
				}
			}
		}
		
		return dp[i][j][seq] = ret;
	}
}
