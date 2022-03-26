package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim11057 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] cnt = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		for(int i = 1; i < n; i++) {
			int[] tmp = new int[10];
			
			for(int j = 0; j < 10; j++) {
				int tmpSum = 0;
				
				for(int k = 0; k <= j; k++) {
					tmpSum += cnt[k];
				}
				
				tmp[j] = tmpSum % 10007;
			}
			
			cnt = tmp;
		}
		
		int sum = 0;
		
		for(int i = 0; i < 10; i++) {
			sum += cnt[i];
		}
		
		System.out.println(sum % 10007);
	}
}
