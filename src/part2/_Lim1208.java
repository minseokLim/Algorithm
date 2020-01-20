package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Lim1208 {
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
		
		for(int i = 0; i < n; i++) {
			dfs(seq, seq[i], i, n, s);
		}
		
		System.out.println(cnt);
	}

	private static void dfs(int[] seq, int sum, int i, int n, int s) {
		if(sum == s) {
			cnt++;
		}
		
		for(int j = i + 1; j < n; j++) {
			dfs(seq, sum + seq[j], j, n, s);
		}
	}
}
