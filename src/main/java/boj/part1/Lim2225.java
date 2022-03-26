package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다시 풀 때 디버깅하면서 주석달자. 또 이거에 시간 뺏기기 싫다...;
public class Lim2225 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[] cnt = new long[n + 1];
		cnt[n] = 1;
		
		for(int i = 1; i < k; i++) {
		
			long[] tmp = new long[n + 1];
			tmp[n] = 1;
			
			for(int j = n - 1; j >= 0; j--) {
				tmp[j] = tmp[j + 1] + cnt[j];
				tmp[j] %= 1_000_000_000;
			}
			
			cnt = tmp;
		}
				
		long sum = 0;
		
		for(int i = 0; i < cnt.length; i++) {
			sum += cnt[i];
		}
		
		System.out.println(sum % 1_000_000_000);
	}
}
