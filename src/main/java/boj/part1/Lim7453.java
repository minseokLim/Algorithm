package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Lim7453 {
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
		
		Map<Integer, Integer> partSum1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> partSum2 = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				Integer partSum = a[i] + b[j];
				Integer partCnt = partSum1.get(partSum);
				
				if(partCnt == null) {
					partSum1.put(partSum, 1);
				} else {
					partSum1.put(partSum, partCnt + 1);
				}			
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				Integer partSum = c[i] + d[j];
				Integer partCnt = partSum2.get(partSum);
				
				if(partCnt == null) {
					partSum2.put(partSum, 1);
				} else {
					partSum2.put(partSum, partCnt + 1);
				}		
			}
		}
		
		Iterator<Integer> iterator = partSum1.keySet().iterator();
		
		while(iterator.hasNext()) {
			Integer x = iterator.next();
			Integer y = partSum2.get(-x);
			
			if(y != null) {
				cnt += ((long) partSum1.get(x)) * y;
			}
		}
		
		System.out.println(cnt);
	}
}
