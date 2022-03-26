package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim11727 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n == 1) {
			System.out.println(1);
			return;
		} else if(n == 2) {
			System.out.println(3);
			return;
		}
		
		int[] ans = new int[n + 1];
	
		ans[1] = 1;
		ans[2] = 3;
		
		for(int i = 3; i <= n; i++) {
			ans[i] = (ans[i - 1] + 2 * ans[i - 2]) % 10007;
		}
		
		System.out.println(ans[n] % 10007);
	}
}
