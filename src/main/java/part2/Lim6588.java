package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lim6588 {
	private static List<Integer> primeNumbers = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int max = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				break;
			}
			
			if(n > max) {
				max = n;
			}
			
			list.add(n);
		}
		
		getPrimeNumbers(max);
		int pSize = primeNumbers.size();
		
		for(int n : list) {
			for(int i = 1; i < pSize; i++) {
				int a = primeNumbers.get(i);
				
				if(isPrime(n - a)) {
					sb.append(n + " = " + a + " + " + (n - a) + "\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
	}
	
	private static void getPrimeNumbers(int max) {
		
		for(int i = 2; i < max; i++) {
			boolean isPrime = isPrime(i);
			
			if(isPrime) {
				primeNumbers.add(i);
			}
		}
	}

	private static boolean isPrime(int i) {
		boolean isPrime = true;
		
		for(int n : primeNumbers) {
			if(n * n > i) break;
			
			if(i % n == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
