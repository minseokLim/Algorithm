package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim11726_3 {
	
	private static int n;
	private static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	
		
		for(int i = 1; i <= 2; i++) {
			add(i, 0);
		}
		
		System.out.println(answer);
	}
	
	private static void add(int a, int b) {
		int sum = a + b;
		
		if(sum < n) {
			for(int i = 1; i <= 2; i++) {
				add(i, sum);
			}
		} else if(sum == n) {
			answer++;
		} 
	}
}
