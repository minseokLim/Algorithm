package boj.part3.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim11053 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] maxes = new int[n];
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			maxes[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(seq[i] > seq[j]) {
					int tmp = maxes[j] + 1;
					
					if(tmp > maxes[i]) {
						maxes[i] = tmp;
					}
				}
			}
			
			if(maxes[i] > answer) {
				answer = maxes[i];
			}
		}
		
		System.out.println(answer);
	}
}
