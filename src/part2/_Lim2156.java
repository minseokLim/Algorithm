package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _Lim2156 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] liquor = new int[n];
		
		for(int i = 0; i < n; i++) {
			liquor[i] = Integer.parseInt(br.readLine());
		}
				
		if(n == 1) {
			System.out.println(liquor[0]);
			return;
		} else if(n == 2) {
			System.out.println(liquor[0] + liquor[1]);
			return;
		}
		
		int[][] ans = new int[3][n];
		ans[0][0] = 0;
		ans[1][0] = liquor[0] == 0 ? -1 : liquor[0];
		ans[2][0] = -1;
		
		for(int i = 2; i < n; i++) {
			ans[0][i] = ans[2][i - 1];
			ans[1][i] = ans[0][i - 1] + liquor[i];
			ans[2][i] = ans[1][i - 1] + liquor[i];
		}
		
		System.out.println(Math.max(Math.max(ans[0][n - 1], ans[1][n - 1]), ans[2][n - 1]));
	}
}
