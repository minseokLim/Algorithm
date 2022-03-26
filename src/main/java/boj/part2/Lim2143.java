package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Lim2143 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] arrA = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] arrB = new int[m];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> subSetA = new ArrayList<Integer>();
		List<Integer> subSetB = new ArrayList<Integer>();
		
		getSubSet(n, arrA, subSetA);
		getSubSet(m, arrB, subSetB);
		
		Collections.sort(subSetA);
		Collections.sort(subSetB);
		
		int left = 0;
		int right = subSetB.size() - 1;
		long cnt = 0;
		
		while(left < subSetA.size() && right >= 0) {
			int leftVal = subSetA.get(left);
			int rightVal = subSetB.get(right);
			int temp = leftVal + rightVal;
			
			if(temp < t) {
				while(++left < subSetA.size() && subSetA.get(left) == leftVal) {
					
				}
			} else if(temp > t) {
				while(--right >= 0 && subSetB.get(right) == rightVal) {
					
				}
			} else {
				long leftCnt = 1;
				long rightCnt = 1;
				
				while(++left < subSetA.size() && subSetA.get(left) == leftVal) {
					leftCnt++;
				}
				
				while(--right >= 0 && subSetB.get(right) == rightVal) {
					rightCnt++;
				}
				
				cnt += leftCnt * rightCnt;
			}
		}
		
		System.out.println(cnt);
	}

	private static void getSubSet(int n, int[] arrA, List<Integer> subSetA) {
		for(int i = 0; i < n; i++) {
			int sum = 0;
			
			for(int j = i; j < n; j++) {
				sum += arrA[j];
				subSetA.add(sum);
			}
		}
	}
}
