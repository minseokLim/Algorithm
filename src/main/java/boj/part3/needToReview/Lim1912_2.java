package boj.part3.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1912_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] seq = new int[n];
		seq[0] = Integer.parseInt(st.nextToken());
		int maxCandidate = seq[0];
		int max = maxCandidate;
		
		for(int i = 1; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
			
			if(maxCandidate > 0) {
				maxCandidate = seq[i] + maxCandidate;
			} else {
				maxCandidate = seq[i];
			}
			
			if(max < maxCandidate) {
				max = maxCandidate;
			}
		}
		
		System.out.println(max);
	}
}
