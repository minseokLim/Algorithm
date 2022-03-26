package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim6588_2 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				break;
			}
			
			for(int i = 3; i < n; i += 2) {				
				if(isPrime(i) && isPrime(n - i)) {
					sb.append(n + " = " + i + " + " + (n - i) + "\n");
					break;
				}
			}
		}
			
		System.out.println(sb);
	}
	
	private static boolean isPrime(int n) {
		boolean isPrime = true;
		
		for(int i = 2; i < n; i++) {
			if(i * i > n) break;
			
			if(n % i == 0) {
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}
}
