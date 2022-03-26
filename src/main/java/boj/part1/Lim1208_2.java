// https://naivep.tistory.com/54?category=810567

package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim1208_2 {
	private static int index;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		if(n == 1) {
			if(Integer.parseInt(st.nextToken()) == s) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			
			return;
		}
		
		int[] left = new int[n / 2];
		int[] leftSubset = new int[1 << left.length];
		int[] right = new int[n - n / 2];
		int[] rightSubset = new int[1 << right.length];
		
		for(int i = 0; i < left.length; i++) {
			left[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < right.length; i++) {
			right[i] = Integer.parseInt(st.nextToken());
		}
		
		index = 0;
		subsetSum(left, leftSubset, 0, 0);
		Arrays.sort(leftSubset);
		
		index = 0;
		subsetSum(right, rightSubset, 0, 0);
		Arrays.sort(rightSubset);
		
		int leftIndex = 0;
		int rightIndex = rightSubset.length - 1;
		long answer = 0;
		
		while(leftIndex < leftSubset.length && rightIndex >= 0) {
			int leftVal = leftSubset[leftIndex];
			int rightVal = rightSubset[rightIndex];
			int sum = leftVal + rightVal;
			
			if(sum == s) {
				int leftCNT = 1;
				
				while(++leftIndex < leftSubset.length && leftSubset[leftIndex] == leftVal) {
					leftCNT++;
				}
				
				int rightCNT = 1;
				
				while(--rightIndex >= 0 && rightSubset[rightIndex] == rightVal) {
					rightCNT++;
				}
				
				answer += ((long) leftCNT) * rightCNT;
				
			} else if(sum < s) {
				while(++leftIndex < leftSubset.length && leftSubset[leftIndex] == leftVal) {
					// nothing
				}			
			} else {
				while(--rightIndex >= 0 && rightSubset[rightIndex] == rightVal) {
					// nothing
				}	
			}
		}
		
		if(s == 0) {
			answer--;
		}
		
		System.out.println(answer);
	}

	private static void subsetSum(int[] arr, int[] subset, int cnt, int sum) {
		if(cnt == arr.length) {
			subset[index++] = sum;
			return;
		}
		
		subsetSum(arr, subset, cnt + 1, sum + arr[cnt]);
		subsetSum(arr, subset, cnt + 1, sum);
	}
}
