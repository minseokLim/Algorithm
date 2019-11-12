package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim11047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		
		for(int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		
		for(int i = n - 1; i >= 0; i--) {
			int q = k / coins[i];
			
			if(q > 0) {
				answer += q;
				k = k % coins[i];
			}
		}
		
		System.out.println(answer);
	}
}
