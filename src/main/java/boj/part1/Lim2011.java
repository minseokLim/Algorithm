package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2011 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = input.length();
		
		if(input.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		
		if(n <= 1) {
			System.out.println(1);
			return;
		}
		
		char[] charArr = input.toCharArray();
		int[] arr = new int[n];
		long[] ans = new long[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = charArr[i] - '0';
		}
		
		ans[0] = 1;
		
		if(arr[1] == 0) {			
			if(arr[0] != 1 && arr[0] != 2) {
				System.out.println(0);
				return;
			} else {
				ans[1] = 1;
			}			
		} else {
			if(arr[0] == 1 || (arr[0] == 2 && arr[1] <= 6)) {
				ans[1] = 2;
			} else {
				ans[1] = 1;
			}		
		}
		
		for(int i = 2; i < n; i++) {
			
			if(arr[i] == 0) {
				
				if(arr[i - 1] != 1 && arr[i - 1] != 2) {
					System.out.println(0);
					return;
				} else {
					ans[i] = ans[i - 2];
				}
			} else {
				if(arr[i - 1] == 1 || (arr[i - 1] == 2 && arr[i] <= 6)) {
					ans[i] = (ans[i - 1] + ans[i - 2]) % 1000000;
				} else {
					ans[i] = ans[i - 1];
				}					
			}
		}
		
		System.out.println(ans[n - 1] % 1000000);
	}
}
