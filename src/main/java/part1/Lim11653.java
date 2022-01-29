package part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lim11653 {
	private static int testLimit = 3162;
	private static int[] primeNumbers = new int[446];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		getPrimeNumbers();		
		
		for(int x : primeNumbers) {
			if(n < x * x) {
				break;
			}
			
			while(n % x == 0) {
				sb.append(x + "\n");
				n /= x;
			}
		}
		
		if(n != 1) {
			sb.append(n);
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
		int j = 0;
		
		while(primeNumbers[j] != 0) {
			
			if(i < primeNumbers[j] * primeNumbers[j]) {
				break;
			}
			
			if(i % primeNumbers[j] == 0) {
				prime = false;
				break;
			}
			
			j++;
		}
		
		return prime;
	}
}
