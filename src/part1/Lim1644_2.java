package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim1644_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		int[] primeNumbers = getPrimeNumbers(N);
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int primeCNT = primeNumbers.length;
		
		while(right < primeCNT) {
			
			if(sum < N) {
				Integer integer = primeNumbers[right++];
				sum += integer;
			} else {
				
				if(sum == N) cnt++;
				
				sum -= primeNumbers[left++];
			}
		}
		
		System.out.println(cnt);
	}
	
	private static int[] getPrimeNumbers(int n) {
		int[] primeNumbers = new int[4000000];
		int idx = 0;
		
		for(int i = 2; i <= n; i++) {
			
			boolean prime = true;
			
			for(int j = 0; j < idx; j++) {
				
				if(i < primeNumbers[j] * primeNumbers[j]) break;
				
				if(i % primeNumbers[j] == 0) {
					prime = false;
					break;
				}
			}
			
			if(prime) {
				primeNumbers[idx++] = i;
			}
		}
		
		int[] newArr = new int[idx + 1];
		System.arraycopy(primeNumbers, 0, newArr, 0, idx);
		
		return newArr;
	}
}
