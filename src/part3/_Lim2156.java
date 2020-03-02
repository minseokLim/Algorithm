package part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _Lim2156 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wines = new int[n];
		int[] maxes = new int[n];
		
		for(int i = 0; i < n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		
		if(n >= 3) {
			maxes[0] = wines[0];
			maxes[1] = wines[0] + wines[1];
			maxes[2] = Math.max(wines[0] + wines[2], wines[1] + wines[2]);
			
			for(int i = 3; i < n; i++) {
				maxes[i] = Math.max(maxes[i - 2] + wines[i], maxes[i - 3] + wines[i - 1] + wines[i]);
			}
			
			System.out.println(Math.max(maxes[n - 1], maxes[n - 2]));
		} else {
			int sum = 0;
			
			for(int i = 0; i < n; i++) {
				sum += wines[i];
			}
			
			System.out.println(sum);
		} 
	}
}
