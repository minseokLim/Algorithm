package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim1463 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ans = new int[n + 1];
		
		ans[1] = 0;
		
		for(int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			
			if(i % 3 == 0) {
				min = ans[i / 3]; 
			}
			
			if(i % 2 == 0 && ans[i / 2] < min) {
				min = ans[i / 2];
			}
			
			if(ans[i - 1] < min) {
				min = ans[i - 1];
			}
			
			ans[i] = min + 1;
		}
		
		System.out.println(ans[n]);
	}
}
