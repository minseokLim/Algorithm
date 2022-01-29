package part3.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim2225 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[n + 1];
		cnt[n] = 1;
		
		for(int i = 2; i <= k; i++) {
			int[] tmp = new int[n + 1];
			tmp[n] = 1;
			
			for(int j = n - 1; j >= 0; j--) {
				tmp[j] = tmp[j + 1] + cnt[j];
				tmp[j] %= 1_000_000_000;
			}
			
			cnt = tmp;
		}
		
		long sum = 0;
		
		for(int i = 0; i <= n; i++) {
			sum += cnt[i];
			sum %= 1_000_000_000;
		}
		
		System.out.println(sum);
	}
}
