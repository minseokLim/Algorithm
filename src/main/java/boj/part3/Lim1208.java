package boj.part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Lim1208 {
	
	private static long answer = 0;
	private static int s;
	private static int[] seq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		seq = new int[n];
		
		for(int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int mid = n / 2;
		Map<Integer, Integer> subsetA = new HashMap<Integer, Integer>();
		Map<Integer, Integer> subsetB = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < mid; i++) {
			getSubset(i, 0, mid, subsetA);
		}
		
		for(int i = mid; i < n; i++) {
			getSubset(i, 0, n, subsetB);
		}
		
		Iterator<Integer> iterator = subsetA.keySet().iterator();
		
		while(iterator.hasNext()) {
			Integer a = iterator.next();
			int countA = subsetA.get(a);
			Integer countB = subsetB.get(s - a);
			
			if(countB != null) {
				answer += 1L * countA * countB;
			}
		}
		
		System.out.println(answer);
	}

	private static void getSubset(int idx, int sum, int limit,  Map<Integer, Integer> subset) {
		sum += seq[idx];
		
		if(sum == s) {
			answer++;
		} 
		
		Integer count = subset.get(sum);
		
		if(count == null) {
			subset.put(sum, 1);
		} else {
			subset.put(sum, count + 1);
		}
		
		for(int i = idx + 1; i < limit; i++) {
			getSubset(i, sum, limit, subset);
		}
	}
}
