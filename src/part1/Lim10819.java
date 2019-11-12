package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim10819 {	
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] copy = new int[n];
		boolean[] visit = new boolean[n];
		method(arr, copy, visit, 0, n);
		
		System.out.println(max);
	}
	
	private static void method(int[] arr, int[] copy, boolean[] visit, int cursor, int n) {
		if(cursor == n) {
			int sum = 0;
			
			for(int i = 0; i < n - 1; i++) {
				sum += Math.abs(copy[i] - copy[i + 1]);
			}
			
			if(max < sum) {
				max = sum;
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				int tmpCursor = cursor;
				int[] tmpCopy = new int[n];
				System.arraycopy(copy, 0, tmpCopy, 0, tmpCursor);
				boolean[] tmpVisit = new boolean[n];
				System.arraycopy(visit, 0, tmpVisit, 0, n);
				tmpVisit[i] = true;
				tmpCopy[tmpCursor++] = arr[i];
				method(arr, tmpCopy, tmpVisit, tmpCursor, n);
			}			
		}
	}
}
