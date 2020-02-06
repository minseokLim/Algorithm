package part3.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] seq = new int[n];
		int[] sums = new int[n];
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
			sum += seq[i];
			sums[i] = sum;
			
			if(max < sums[i]) {
				max = sums[i];
			} 
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				int tmp = sums[i] - sums[j];
				
				if(max < tmp) {
					max = tmp;
				}
			}
		}
		
		System.out.println(max);
	}
}
