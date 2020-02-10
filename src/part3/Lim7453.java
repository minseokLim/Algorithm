package part3;

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
		
		int[] subsetAB = getSubset(n, a, b);
		int[] subsetCD = getSubset(n, c, d);
		
		Arrays.sort(subsetAB);
		Arrays.sort(subsetCD);
		
		int left = 0;
		int right = n * n - 1;
		long cnt = 0;
		
		while(left < n * n && right >= 0) {
			int leftVal = subsetAB[left];
			int rightVal = subsetCD[right];
			int tmp = leftVal + rightVal;
			
			if(tmp < 0) {
				while(++left < n * n && subsetAB[left] == leftVal) {
					// do nothing
				}
			} else if(tmp > 0) {
				while(--right >= 0 && subsetCD[right] == rightVal) {
					// do nothing
				}
			} else {
				long leftCnt = 1;
				long rightCnt = 1;
				
				while(++left < n * n && subsetAB[left] == leftVal) {
					leftCnt++;
				}
				
				while(--right >= 0 && subsetCD[right] == rightVal) {
					rightCnt++;
				}
				
				cnt += leftCnt * rightCnt;
			}
		}
		
		System.out.println(cnt);
	}

	private static int[] getSubset(int n, int[] a, int[] b) {
		int[] subset = new int[n * n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				subset[i * n + j] = a[i] + b[j];
			}
		}
		
		return subset;
	}
}
