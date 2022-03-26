package boj.part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxCandidate = seq[0];
		int max = seq[0];
		
		// 연속합의 최대값을 구성하는 부분수열은 음수로 시작할 수 없다.
		// 비교 시점에서 이전 부분수열의 합이 음수라면, 포함시킬 가치가 없다.
		// maxCandidate는 결국 비교시점 바로 이전까지 더해진 수열의 합을 의미
		for(int i = 1; i < n; i++) {
			
			if(maxCandidate <= 0) {
				maxCandidate = seq[i];
			} else {
				maxCandidate += seq[i];
			}
			
			if(maxCandidate > max) {
				max = maxCandidate;
			}
		}
		
		System.out.println(max);
	}
}
