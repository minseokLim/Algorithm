package boj.part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim9466_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] choices = new int[n + 1];
			boolean[] checked = new boolean[n + 1];
			boolean[] reVisited = new boolean[n + 1];
			boolean[] chosen = new boolean[n + 1];
			
			for(int j = 1; j <= n; j++) {
				choices[j] = Integer.parseInt(st.nextToken());
				chosen[choices[j]] = true;
			}
			
			int cnt = 0;
			
			for(int j = 1; j <= n; j++) {
				if(!chosen[j]) {
					boolean[] visited = new boolean[n + 1];
					dfs(choices, visited, reVisited, j, checked);
				}
			}
			
			for(int j = 1; j <= n; j++) {
				if(!reVisited[j]) cnt++;
				if(!checked[j]) cnt--;
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int[] choices, boolean[] visited, boolean[] reVisited, int idx, boolean[] checked) {
		
		if(visited[idx]) {
			reVisited[idx] = true;
		} else {
			visited[idx] = true;
			checked[idx] = true;
		}
		
		int next = choices[idx];
		
		if(!reVisited[next]) {
			dfs(choices, visited, reVisited, next, checked);
		}
	}
}
