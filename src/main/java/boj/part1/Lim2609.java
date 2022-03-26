package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim2609 {
	private static List<Integer> primeNumbers = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = a * b;
		getPrimeNumbers(Math.max(a, b));
		
		int g = 1;
		
		for(int n : primeNumbers) {
			
			while(a % n == 0 && b % n == 0) {
				g *= n;
				a /= n;
				b /= n;
			}
			
			if(a < n || b < n) {
				break;
			}
		}
		
		System.out.println(g);
		System.out.println(m / g);
	}
	
	private static void getPrimeNumbers(int max) {
		primeNumbers.add(2);
		
		for(int i = 3; i <= max; i++) {
			
			boolean prime = true;
			
			for(int j : primeNumbers) {
				
				if(i % j == 0) {
					prime = false;
					break;
				}
			}
			
			if(prime) {
				primeNumbers.add(i);
			}
		}
	}
}
