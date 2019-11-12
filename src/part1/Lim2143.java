package part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Lim2143 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		getArr(br, n, a);
		
		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		
		getArr(br, m, b);
		
		Map<Integer, Integer> partSumA = new HashMap<Integer, Integer>();
		
		getPartSum(n, a, partSumA);
		
		Map<Integer, Integer> partSumB = new HashMap<Integer, Integer>();
		
		getPartSum(m, b, partSumB);
		
		Iterator<Integer> aKeys = partSumA.keySet().iterator();
		
		long cnt = 0;
		
		while(aKeys.hasNext()) {
			Integer aKey = aKeys.next();
			Integer bValue = partSumB.get(T - aKey);
			
			if(bValue != null) {
				cnt += partSumA.get(aKey) * ((long) bValue);
			}
		}
		
		System.out.println(cnt);
	}

	private static void getPartSum(int len, int[] arr, Map<Integer, Integer> partSum) {
		for(int i = 0; i < len; i++) {
			int sum = 0;
			
			for(int j = i; j < len; j++) {
				sum += arr[j];
				
				Integer partCNT = partSum.get(sum);
				
				if(partCNT == null) {
					partSum.put(sum, 1);
				} else {
					partSum.put(sum, partCNT + 1);
				}
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
