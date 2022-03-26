package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim11054 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n];
		int[] max1 = new int[n];
		int[] max2 = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		max1[0] = 1;
		max2[n - 1] = 1;
		
		for(int i = 1; i < n; i++) {
			max1[i] = 1;
			
			for(int j = i - 1; j >= 0; j--) {
				
				if(seq[j] < seq[i] && max1[j] + 1 > max1[i]) {
					max1[i] = max1[j] + 1;
				}
			}
		}
		
		for(int i = n - 2; i >= 0; i--) {
			max2[i] = 1;
			
			for(int j = i + 1; j < n; j++) {
				
				if(seq[j] < seq[i] && max2[j] + 1 > max2[i]) {
					max2[i] = max2[j] + 1;
				}
			}
		}
		
		int answer = max1[0] + max2[0] - 1;
		
		for(int i = 1; i < n; i++) {
			
			if(answer < max1[i] + max2[i] - 1) {
				answer = max1[i] + max2[i] - 1;
			}
		}
		
		System.out.println(answer);
	}
}
