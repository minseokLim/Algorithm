// https://naivep.tistory.com/54?category=810567

package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Lim1208 {
	private static long cnt = 0;
	
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
			
			return;
		}
		
		int middle = n / 2;
		
		Map<Integer, Long> partSum1 = new TreeMap<Integer, Long>();
		
		for(int i = 0; i < middle; i++) {
			dfs(i, seq, seq[i], s , middle, partSum1);
		}
				
		Map<Integer, Long> partSum2 = new TreeMap<Integer, Long>(Collections.reverseOrder());
		
		for(int i = middle; i < n; i++) {
			dfs(i, seq, seq[i], s , n, partSum2);
		}
		
		Iterator<Integer> iterator1 = partSum1.keySet().iterator();
		Iterator<Integer> iterator2 = partSum2.keySet().iterator();
		int a = iterator1.next();
		int b = iterator2.next();
		
		while(true) {
			int sum = a + b;
			
			try {
				if(sum == s) {
					cnt += partSum1.get(a) * partSum2.get(b);
					a = iterator1.next();
					b = iterator2.next();
				} else if(sum < s) {
					a = iterator1.next();
				} else {
					b = iterator2.next();
				}
			} catch (NoSuchElementException e) {
				break;
			}			
		}
		
			
		System.out.println(cnt);
	}
	
	private static void dfs(int i, int[] seq, int sum, int s, int end, Map<Integer, Long> partSum) {
		
		if(sum == s) {
			cnt++;
		} 
		
		Long n = partSum.get(sum);
		
		if(n == null) {
			partSum.put(sum, 1L);
		} else {
			partSum.put(sum, n + 1);
		}
		
		for(int j = i + 1; j < end; j++) {
			dfs(j, seq, sum + seq[j], s, end, partSum);
		}
	}
}
