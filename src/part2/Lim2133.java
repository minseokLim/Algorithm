package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2133 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if((n & 1) == 1) {
			System.out.println(0);
			return;
		}
		
		n /= 2;
		
		int[] cnt = new int[n + 1];
		cnt[0] = 1;
		cnt[1] = 3;
		
		for(int i = 2; i <= n; i++) {
			cnt[i] += cnt[i - 1] * 3;
			
			int tmp = 2;
			
			while(tmp <= i) {
				cnt[i] += cnt[i - tmp] * 2;
				tmp++;
			}
		}
		
		System.out.println(cnt[n]);
	}
}
