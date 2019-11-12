package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lim1644 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		List<Integer> primeNumbers = getPrimeNumbers(N);
		primeNumbers.add(0);
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int primeCNT = primeNumbers.size();
		
		while(right < primeCNT) {
			
			if(sum < N) {
				Integer integer = primeNumbers.get(right++);
				sum += integer;
			} else {
				
				if(sum == N) cnt++;
				
				sum -= primeNumbers.get(left++);
			}
		}
		
		System.out.println(cnt);
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
