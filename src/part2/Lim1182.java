package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1182 {
	private static int cnt = 0;
	
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
			int[] selectedIdx = new int[i];
			
			combination(seq, selectedIdx, n, i, s, 0, 0);
		}
		
		System.out.println(cnt);
	}

	private static void combination(int[] seq, int[] selectedIdx, int n, int r, int s, int target, int depth) {
		if(depth == r) {
			int sum = 0;
			
			for(int i = 0; i < r; i++) {
				sum += seq[selectedIdx[i]];
			}
			
			if(sum == s) {
				cnt++;
			}		
		} else if(target < n) {
			selectedIdx[depth] = target;
			combination(seq, selectedIdx, n, r, s, target + 1, depth + 1);
			combination(seq, selectedIdx, n, r, s, target + 1, depth);
		}	
	}
}
