package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Lim1208 {
	private static int cnt = 0;
	private static int index = 0;
	
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
		}
		
		int[] left = new int[n / 2];
		System.arraycopy(seq, 0, left, 0, left.length);
		int[] right = new int[n - n / 2];
		System.arraycopy(seq, left.length, right, 0, right.length);
		
		int[] leftSumSet = new int[1 << left.length];
		int[] rightSumSet = new int[1 << right.length];
		leftSumSet[0] = 0;
		rightSumSet[0] = 0;
		
		index = 1;
		
		for(int i = 0; i < left.length; i++) {
			dfs(left, left[i], i, leftSumSet, s);
		}
		
		index = 1;
		
		for(int i = 0; i < right.length; i++) {
			dfs(right, right[i], i, rightSumSet, s);
		}
		
		Arrays.sort(leftSumSet);
		Arrays.sort(rightSumSet);
		
		int leftIdx
		
		System.out.println(cnt);
	}

	private static void dfs(int[] seq, int sum, int i, int[] sumSet, int s) {
		sumSet[index++] = sum;
		
		for(int j = i + 1; j < seq.length; j++) {
			dfs(seq, sum + seq[j], j, sumSet, s);
		}
	}
}
