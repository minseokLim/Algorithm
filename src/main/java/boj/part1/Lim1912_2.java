package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1912_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int maxCandidate = Integer.parseInt(st.nextToken());
		int max = maxCandidate;
		
		for(int i = 1; i < n; i++) {
			int elem = Integer.parseInt(st.nextToken());
			
			if(maxCandidate < 0) {
				maxCandidate = elem;
			} else {
				maxCandidate += elem;
			}
			
			if(maxCandidate > max) {
				max = maxCandidate;
			}
		}
		
		System.out.println(max);
	}
}
