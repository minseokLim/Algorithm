package boj.part3.questionList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim7453 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] subSet1 = new int[n * n];
		int[] subSet2 = new int[n * n];
		
		setSubset(n, a, b, subSet1);
		setSubset(n, c, d, subSet2);
		a = null; b = null; c = null; d = null;
		
		Arrays.sort(subSet1);
		Arrays.sort(subSet2);
		
		int leftIdx = 0;
		int rightIdx = subSet2.length - 1;
		long cnt = 0;
		
		while(leftIdx < n * n && rightIdx >= 0) {
			int leftVal = subSet1[leftIdx];
			int rightVal = subSet2[rightIdx];
			int temp = leftVal + rightVal;
			
			if(temp < 0) {
				while(++leftIdx < n * n && subSet1[leftIdx] == leftVal) {
					// do nothing
				}
			} else if(temp > 0) {
				while(--rightIdx >= 0 && subSet2[rightIdx] == rightVal) {
					// do nothing
				}
			} else {
				long leftCnt = 1;
				long rightCnt = 1;
				
				while(++leftIdx < n * n && subSet1[leftIdx] == leftVal) {
					leftCnt++;
				}
				
				while(--rightIdx >= 0 && subSet2[rightIdx] == rightVal) {
					rightCnt++;
				}
				
				cnt += leftCnt * rightCnt;
			}
		}
		
		System.out.println(cnt);
	}

	private static void setSubset(int n, int[] a, int[] b, int[] subSet) {
		int idx = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				subSet[idx++] = a[i] + b[j];
			}
		}
	}
}
