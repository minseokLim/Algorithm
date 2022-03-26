package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim1699 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] min = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			min[i] = i;
			int j = (int) Math.sqrt(i);
			
			while(j > 1) {
				int temp = min[i - j * j] + 1;
				
				if(temp < min[i]) {
					min[i] = temp;
				}
				
				j--;
			}
		}
		
		System.out.println(min[n]);
	}
}
