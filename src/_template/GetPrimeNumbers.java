package _template;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GetPrimeNumbers {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		
		List<Integer> primeNumbers = getPrimeNumbers(N);
		
		System.out.println(primeNumbers);
	}

	private static List<Integer> getPrimeNumbers(int n) {
		List<Integer> primeNumbers = new ArrayList<Integer>();
		
		for(int i = 2; i <= n; i++) {
			
			boolean prime = true;
			
			for(int num : primeNumbers) {
				
				if(i < num * num) break;
				
				if(i % num == 0) {
					prime = false;
					break;
				}
			}
			
			if(prime) {
				primeNumbers.add(i);
			}
		}
		
		return primeNumbers;
	}
}
