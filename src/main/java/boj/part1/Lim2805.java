package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] treeHeight = new int[n];
		st = new StringTokenizer(br.readLine());
		
		int treeMax = 0;
		
		for(int i = 0; i < n; i++) {
			treeHeight[i] = Integer.parseInt(st.nextToken());
			
			if(treeMax < treeHeight[i]) {
				treeMax = treeHeight[i];
			}
		}
		
		int max = binarySearch(treeHeight, m, treeMax);
		
		System.out.println(max);
	}

	private static int binarySearch(int[] treeHeight, int m, int treeMax) {
		Arrays.sort(treeHeight);
		
		int left = 0;
		int right = treeMax - 1;
		int answer = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			boolean possible = false;
			long sum = 0;
			
			for(int i = treeHeight.length - 1; i >= 0; i--) {
				int tmp = treeHeight[i] - mid;
				
				if(tmp > 0) {
					sum += tmp;
				}
							
				if(sum >= m) {
					possible = true;
					break;
				}
			}
			
			if(possible) {
				left = mid + 1;
				answer = mid;
			} else {
				right = mid - 1;
			}
		}
		
		return answer;
	}
}
