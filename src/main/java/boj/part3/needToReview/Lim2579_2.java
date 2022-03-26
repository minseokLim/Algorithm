package boj.part3.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2579_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] scores = new int[300];
		int[][] max = new int[2][300];
		
		for(int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		
		max[0][0] = scores[0];
		max[0][1] = scores[1];
		max[1][1] = scores[0] + scores[1];
		
		for(int i = 2; i < n; i++) {
			max[0][i] = Math.max(max[0][i - 2], max[1][i - 2]) + scores[i];
			max[1][i] = max[0][i - 1] + scores[i];
		}
		
		System.out.println(Math.max(max[0][n - 1], max[1][n - 1]));
	}
}
