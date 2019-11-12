package part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim2143_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		getArr(br, n, a);
		
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		
		getArr(br, m, b);
		
		int[] aSubset = new int[n * (n + 1) / 2];
		int[] bSubset = new int[m * (m + 1) / 2];
		
		getSubset(n, a, aSubset);
		getSubset(m, b, bSubset);
		
		Arrays.sort(aSubset);
		Arrays.sort(bSubset);
		
		int leftIdx = 0;
		int rightIdx = bSubset.length - 1;
		
		long answer = 0;
		
		while(leftIdx < aSubset.length && rightIdx >= 0) {
			int leftVal = aSubset[leftIdx];
			int rightVal = bSubset[rightIdx];
			int sum = leftVal + rightVal;
			
			if(sum == T) {
				int leftCNT = 1;
				
				while(++leftIdx < aSubset.length && aSubset[leftIdx] == leftVal) {
					leftCNT++;
				}
				
				int rightCNT = 1;
				
				while(--rightIdx >= 0 && bSubset[rightIdx] == rightVal) {
					rightCNT++;
				}
				
				answer += ((long) leftCNT) * rightCNT;
			} else if(sum < T) {
				while(++leftIdx < aSubset.length && aSubset[leftIdx] == leftVal) {}
			} else {
				while(--rightIdx >= 0 && bSubset[rightIdx] == rightVal) {}
			}
		}
		
		System.out.println(answer);
	}

	private static void getSubset(int n, int[] a, int[] aSubset) {
		int idx = 0;
		
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = i; j < n; j++) {
				sum += a[j];
				aSubset[idx++] = sum;
			}
		}
	}

	private static void getArr(BufferedReader br, int len, int[] arr) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}
