package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2579 {
	
	private static int[] scores;
	private static int[] max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		scores = new int[n];
		max = new int[n];
		
		for(int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(findMaxScore(n - 1));
	}
	
	private static int findMaxScore(int i) {
		if(max[i] != 0) {
			return max[i];
		}
		
		switch (i) {
			case 0:
				return scores[0];
			case 1:
				return scores[0] + scores[1];
			case 2:
				return Math.max(scores[0] + scores[2], scores[1] + scores[2]);
		}
		
		max[i] = Math.max(findMaxScore(i - 2), findMaxScore(i - 3) + scores[i - 1]) + scores[i];
		return max[i];
	}
}
