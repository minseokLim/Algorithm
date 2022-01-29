package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lim1978_2 {
	private static List<Integer> primeNumbers = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int[] numbers = new int[inputs.length];
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(inputs[i]);
			
			if(max < numbers[i]) {
				max = numbers[i];
			}
		}
		
		getPrimeNumbers(max);
		
		int cnt = 0;
		
		for(int x : numbers) {
			
			if(primeNumbers.contains(x)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	private static void getPrimeNumbers(int max) {
		primeNumbers.add(2);
		
		for(int i = 3; i <= max; i++) {
			
			boolean prime = true;
			
			for(int n : primeNumbers) {
				
				// 이 부분이 추가될 수 있는 이유에 대한 수학적 증명이나 이해가 필요할 듯
				if(i < n * n) {
					break;
				}
				
				if(i % n == 0) {
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
