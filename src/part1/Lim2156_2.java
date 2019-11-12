package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2156_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n + 1];
		int[] max = new int[n + 1];
		
		for(int i = 1; i < n + 1; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		max[1] = wine[1];
		
		if(n >= 2) {
			
			max[2] = wine[1] + wine[2];
			
			for(int i = 3; i < n + 1; i++) {
				max[i] = maxValue(max[i - 1], max[i - 2] + wine[i], max[i - 3] + wine[i - 1] + wine[i]);
			}
		} 
		
		System.out.println(max[n]);
	}
	
	private static int maxValue(int... args) {
		int max = args[0];
		
		for(int i = 1; i < args.length; i++) {
			if(max < args[i]) {
				max = args[i];
			}
		}
		
		return max;
	}
}
