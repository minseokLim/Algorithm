package boj.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Lim2632 {
	
	private static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int want = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] a = new int[m];
		int[] b = new int[n];
		
		Map<Integer, Integer> partSum1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> partSum2 = new HashMap<Integer, Integer>();
		
		getPizzaArr(br, want, m, a, partSum1);		
		getPizzaArr(br, want, n, b, partSum2);
		
		getPartSum(m, a, partSum1, want);
		getPartSum(n, b, partSum2, want);
		
		Iterator<Integer> iterator = partSum1.keySet().iterator();
		
		while(iterator.hasNext()) {
			int partSum = iterator.next();
			
			if(want - partSum > 0) {
				Integer partCNT = partSum2.get(want - partSum);
				
				if(partCNT != null) {
					cnt += partSum1.get(partSum) * partCNT;
				}
			}
		}
		
		System.out.println(cnt);
	}

	private static void getPizzaArr(BufferedReader br, int want, int len, int[] arr, Map<Integer, Integer> partSum) throws IOException {
		int sum = 0;
		
		for(int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		if(sum == want) cnt++;
		
		partSum.put(sum, 1);
	}

	private static void getPartSum(int len, int[] arr, Map<Integer, Integer> partSum, int want) {
		
		for(int i = 0; i < len; i++) {
			int sum = 0;
			
			for(int j = 0; j < len - 1; j++) {
				int idx = i + j;
				
				if(idx >= len) {
					idx -= len;
				}
				
				sum += arr[idx];
				
				if(sum == want) cnt++;
				
				Integer partCNT = partSum.get(sum);
				
				if(partCNT == null) {
					partSum.put(sum, 1);
				} else {
					partSum.put(sum, partCNT + 1);
				}
			}
		}
	}
}
