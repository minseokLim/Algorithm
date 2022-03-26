package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim11052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] prices = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] maxArr = new int[n + 1];
		maxArr[1] = prices[1];
		
		for(int i = 2; i <= n; i++) {
			maxArr[i] = prices[i];
			
			for(int j = 1; j <= i / 2; j++) {
				int tmp = maxArr[j] + maxArr[i - j];
				
				if(tmp > maxArr[i]) {
					maxArr[i] = tmp;
				}
			}
		}
		
		System.out.println(maxArr[n]);
	}
}
