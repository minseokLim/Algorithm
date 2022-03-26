package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1654 {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] lineArr = new int[k];
		long sum = 0;
		
		for(int i = 0; i < k; i++) {
			lineArr[i] = Integer.parseInt(br.readLine());					
			sum += lineArr[i];
		}
				
		long answer = sum / n;
		long left = 0;
		long right = answer;
				
		while(left <= right) {
			int cnt = 0;
			
			for(int i = 0; i < k; i++) {
				cnt += lineArr[i] / answer;
			}
					
			if(cnt >= n) {
				left = answer + 1;
			} else if(cnt < n) {
				right = answer - 1;
			} 
			
			answer = (left + right) / 2;
		}
				
		System.out.println(answer);	
	}
}
