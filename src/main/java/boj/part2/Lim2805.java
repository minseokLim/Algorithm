package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] trees = new int[n];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			
			if(max < trees[i]) {
				max = trees[i];
			}
		}
		
		int left = 0;
		int right = max;
		int answer = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(checkPossibility(trees, mid, m)) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}

	private static boolean checkPossibility(int[] trees, int mid, int m) {
		long sum = 0;
		
		for(int elem : trees) {
			if(elem > mid) {
				sum += elem - mid;
			}			
		}
		
		return sum >= m;
	}
}
