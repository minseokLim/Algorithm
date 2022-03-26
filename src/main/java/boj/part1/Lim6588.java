package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim6588 {
	private static int arrSize = 78498;
	private static int testLimit = 100_0000;
	private static int[] primeNumbers = new int[arrSize];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n;
		
		getPrimeNumbers();

		while((n = Integer.parseInt(br.readLine())) != 0) {
			
			for(int i = 1; i < arrSize; i++) {
				
				if(primeNumbers[i] > n) {
					sb.append("Goldbach's conjecture is wrong.");
					break;
				}
				
				int b = n - primeNumbers[i];
				
				if(b != 2 && checkIfPrime(b)) {
					sb.append(n + " = " + primeNumbers[i] + " + " + b + "\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
		
	}
	
	private static void getPrimeNumbers() {
		int idx = 0;
		primeNumbers[idx++] = 2;
		
		for(int i = 3; i <= testLimit; i++) {			
			boolean prime = checkIfPrime(i);
			
			if(prime) {
				primeNumbers[idx++] = i;
			}
		}
	}

	private static boolean checkIfPrime(int i) {
		boolean prime = true;
		
		for(int j : primeNumbers) {
			
			if(i < j * j) {
				break;
			}
			
			if(i % j == 0) {
				prime = false;
				break;
			}
		}
		return prime;
	}
}
