package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim11727 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		solution(n);
	}
	
	private static void solution(int n) {
		if(n == 1) {
			System.out.println("1");
			return;
		} 
		
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 3;
		
		for(int i = 2; i < n; i++) {
			arr[i] = arr[i - 1] + 2 * arr[i - 2];
			
			if(arr[i] >= 10007) {
				arr[i] %= 10007;
			}
		}
		
		System.out.println(arr[n - 1]);
	}
}
