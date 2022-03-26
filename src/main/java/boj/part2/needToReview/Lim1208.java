package boj.part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim1208 {
	private static int index = 0;
	private static long cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] seq = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		if(n == 1) {
			if(seq[0] == s) {
				System.out.println(1);		
			} else {
				System.out.println(0);
			}
			
			return;
		}
		
		int[] left = new int[n / 2];
		System.arraycopy(seq, 0, left, 0, left.length);
		int[] right = new int[n - n / 2];
		System.arraycopy(seq, left.length, right, 0, right.length);
		seq = null;
		
		int[] leftSumSet = new int[(1 << left.length) - 1];
		int[] rightSumSet = new int[(1 << right.length) - 1];
		
		index = 0;
		
		for(int i = 0; i < left.length; i++) {
			dfs(left, left[i], i, leftSumSet, s);
		}
		
		index = 0;
		
		for(int i = 0; i < right.length; i++) {
			dfs(right, right[i], i, rightSumSet, s);
		}
		
		Arrays.sort(leftSumSet);
		Arrays.sort(rightSumSet);
		
		int leftIdx = 0;
		int rightIdx = rightSumSet.length - 1;
		
		while(leftIdx < leftSumSet.length && rightIdx >= 0) {
			int leftVal = leftSumSet[leftIdx];
			int rightVal = rightSumSet[rightIdx];
			int temp = leftVal + rightVal;
			
			if(temp < s) {
				while(++leftIdx < leftSumSet.length && leftVal == leftSumSet[leftIdx]) {
					// do nothing
				}
			} else if(temp > s) {
				while(--rightIdx >= 0 && rightVal == rightSumSet[rightIdx]) {
					// do nothing
				}
			} else {
				long leftCnt = 1;
				long rightCnt  = 1;
				
				while(++leftIdx < leftSumSet.length && leftVal == leftSumSet[leftIdx]) {
					leftCnt++;
				}
				
				while(--rightIdx >= 0 && rightVal == rightSumSet[rightIdx]) {
					rightCnt++;
				}
				
				cnt += leftCnt * rightCnt;
			}
		}
				
		System.out.println(cnt);
	}

	private static void dfs(int[] seq, int sum, int i, int[] sumSet, int s) {
		sumSet[index++] = sum;
		
		if(sum == s) cnt ++;
				
		for(int j = i + 1; j < seq.length; j++) {
			dfs(seq, sum + seq[j], j, sumSet, s);
		}
	}
}
