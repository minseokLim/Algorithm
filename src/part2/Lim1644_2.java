package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lim1644_2 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<Integer>();
		boolean[] isNotPrime = new boolean[n + 1];
		
		calPrime(isNotPrime, n);
		setPrime(list, isNotPrime, n);
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int cnt = 0;
		
		while(true) {
			try {
				if(sum < n) {
					sum += list.get(right++);
				} else {
					if(sum == n) {
						cnt++;
					}
					
					sum -= list.get(left++);
				}
			} catch (IndexOutOfBoundsException e) {
				break;
			}		
		}
		
		System.out.println(cnt);
	}

	private static void setPrime(List<Integer> list, boolean[] isNotPrime, int n) {
		for(int i = 2; i <= n; i++) {
			if(!isNotPrime[i]) {
				list.add(i);
			}
		}
	}

	private static void calPrime(boolean[] isNotPrime, int n) {
		int max = (int) Math.sqrt(n);
		
		for(int i = 2; i <= max; i++) {
			if(isNotPrime[i]) {
				continue;
			}
			
			for(int j = i + i; j <= n; j += i) {
				isNotPrime[j] = true;
			}
		}
	}
}

