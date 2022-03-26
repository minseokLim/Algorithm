package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1182_2 {
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
		
		for(int i = 0; i < n; i++) {
			dfs(i, seq, seq[i], s);
		}
		
		System.out.println(answer);
	}

	private static void dfs(int i, int[] seq, int sum, int s) {
		
		if(sum == s) {
			answer++;
		}
		
		for(int j = i + 1; j < seq.length; j++) {
			dfs(j, seq, sum + seq[j], s);
		}
	}
}
