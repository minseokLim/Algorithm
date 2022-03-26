package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim9095 {
	private static int[] caseNums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] testNum = new int[n];
		testNum[0] = Integer.parseInt(br.readLine());
		int max = testNum[0];
		
		for(int i = 1; i < n; i++) {
			testNum[i] = Integer.parseInt(br.readLine());
			
			if(testNum[i] > max) {
				max = testNum[i];
			}
		}
		
		solution(max);
		
		for(int i = 0; i < n; i++) {
			System.out.println(caseNums[testNum[i] - 1]);
		}
	}
	
	private static void solution(int max) {
		caseNums = new int[Math.max(3, max)];
		caseNums[0] = 1;
		caseNums[1] = 2;
		caseNums[2] = 4;
		
		for(int i = 3; i < max; i++) {
			caseNums[i] = caseNums[i - 1] + caseNums[i - 2] + caseNums[i - 3];
		}
	}
}
