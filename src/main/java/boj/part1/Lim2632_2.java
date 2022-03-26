package boj.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim2632_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int want = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] a = new int[m];
		int[] b = new int[n];
		
		int wholeA = getPizzaArr(br, m, a);		
		int wholeB = getPizzaArr(br, n, b);
		
		// 여기서 +1 이 아닌 +2를 하는 이유는, 0인 원소 하나를 만들어 둠으로써 둘 중 하나의 피자만 선택하는 경우도 나올 수 있게 해주기 위해서이다.
		int[] aSubset = new int[(m - 1) * m + 2];
		int[] bSubset = new int[(n - 1) * n + 2];
		
		getSubset(m, a, aSubset);
		getSubset(n, b, bSubset);
		
		aSubset[(m - 1) * m] = wholeA;
		bSubset[(n - 1) * n] = wholeB;
		
		Arrays.sort(aSubset);
		Arrays.sort(bSubset);
		
		int leftIdx = 0;
		int rightIdx = bSubset.length - 1;
		long answer = 0;
		
		while(leftIdx < aSubset.length && rightIdx >= 0) {
			int leftVal = aSubset[leftIdx];
			int rightVal = bSubset[rightIdx];
			int sum = leftVal + rightVal;
			
			if(sum == want) {
				int leftCNT = 1;
				
				while(++leftIdx < aSubset.length && aSubset[leftIdx] == leftVal) {
					leftCNT++;
				}
				
				int rightCNT = 1;
				
				while(--rightIdx >= 0 && bSubset[rightIdx] == rightVal) {
					rightCNT++;
				}
				
				answer += ((long) leftCNT) * rightCNT;
			} else if(sum < want) {
				while(++leftIdx < aSubset.length && aSubset[leftIdx] == leftVal) {}
			} else {
				while(--rightIdx >= 0 && bSubset[rightIdx] == rightVal) {}
			}
		}
		
		// 일반적인 경우에는 넣어주는 게 맞으나 여기선 want가 0으로 들어오는 경우가 없음
//		if(want == 0) {
//			answer--;
//		}
		
		System.out.println(answer);
	}

	private static void getSubset(int m, int[] a, int[] aSubset) {
		int subIndex = 0;
		
		for(int i = 0; i < m; i++) {
			int sum = 0;
			int idx = i;
			
			for(int j = 0; j < m - 1; j++) {
				
				if(idx >= m) {
					idx -= m;
				}
				
				sum += a[idx++];
				aSubset[subIndex++] = sum;
			}
		}		
	}

	private static int getPizzaArr(BufferedReader br, int len, int[] arr) throws IOException {		
		int sum = 0;
		
		for(int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		return sum;
	}
}
