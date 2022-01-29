package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim7453_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		long cnt = 0;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());		
		}
		
		int[] abSubset = getSetset(n, a, b);
		int[] cdSubset = getSetset(n, c, d);
		
		int leftIdx = 0;
		int rightIdx = cdSubset.length - 1;
		
		while(leftIdx < abSubset.length && rightIdx >= 0) {
			int leftVal = abSubset[leftIdx];
			int rightVal = cdSubset[rightIdx];
			int sum = leftVal + rightVal;
			
			if(sum == 0) {
				int leftCNT = 1;
				
				while(++leftIdx < abSubset.length && abSubset[leftIdx] == leftVal) {
					leftCNT++;
				}
				
				int rightCNT = 1;
				
				while(--rightIdx >= 0 && cdSubset[rightIdx] == rightVal) {
					rightCNT++;
				}				
				
				cnt += ((long) leftCNT) * rightCNT;
			} else if(sum < 0) {
				while(++leftIdx < abSubset.length && abSubset[leftIdx] == leftVal) {}
			} else {
				while(--rightIdx >= 0 && cdSubset[rightIdx] == rightVal) {}
			}
		}
		
		System.out.println(cnt);
	}

	private static int[] getSetset(int n, int[] a, int[] b) {
		
		int[] abSubset = new int[n * n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				abSubset[n * i + j] = a[i] + b[j];
			}
		}
		
		Arrays.sort(abSubset);
		
		return abSubset;
	}
}
