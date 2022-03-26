package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim10844 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] cnt = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		for(int i = 0; i < n - 1; i++) {
			long[] tmp = new long[10];
			tmp[0] = cnt[1] % 1_000_000_000;
			
			for(int j = 1; j < 9; j++) {
				tmp[j] = (cnt[j - 1] + cnt[j + 1]) % 1_000_000_000;
			}
			
			tmp[9] = cnt[8] % 1_000_000_000;
			
			cnt = tmp;
		}
		
		long sum = 0;
		
		for(long a : cnt) {
			sum += a;
		}
		
		System.out.println(sum % 1_000_000_000);
	}
}
