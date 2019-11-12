package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2193 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] cnt = {0, 1};
		
		for(int i = 1; i < n; i++) {
			long[] tmp = new long[2];
			tmp[0] = cnt[0] + cnt[1];
			tmp[1] = cnt[0];
			cnt = tmp;
		}
		
		System.out.println(cnt[0] + cnt[1]);
	}
}
