package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1182 {
	private static int answer = 0;
	
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
		
		for(int i = 1; i <= n; i++) {
			int[] combArr = new int[i];
			
			combination(combArr, n, i, 0, 0, seq, s);
		}
		
		System.out.println(answer);
	}

	private static void combination(int[] combArr, int n, int r, int index, int target, int[] seq, int s) {
		
		if(r == 0) {
			int sum = 0;
			
			for(int i = 0; i < combArr.length; i++) {
				sum += seq[combArr[i]];
			}
			
			if(sum == s) {
				answer++;
			}
			
		} else if(target == n) {
			return;
		} else {
			combArr[index] = target;
			combination(combArr, n, r - 1, index + 1, target + 1, seq, s);
			combination(combArr, n, r, index, target + 1, seq, s);
		}	
	}
}
