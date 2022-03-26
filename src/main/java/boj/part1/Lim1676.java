package boj.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lim1676 {
	private static int two = 0;
	private static int five = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for(int i = 2; i <= n; i++) {
			cal(i);
		}
		
		System.out.println(Math.min(two, five));
	}
	
	private static void cal(int n) {
		
		while(n % 2 == 0) {
			n /= 2;
			two++;
		}
		
		while(n % 5 == 0) {
			n /= 5;
			five++;
		}
	}
}
