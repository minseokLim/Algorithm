package part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Lim1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			int sum = 0;
			
			for(int j = i; j < n; j++) {
				sum += seq[j];
				
				if(sum > max) { 
					max = sum;
				}
			}
		}
		
		System.out.println(max);
	}
}
