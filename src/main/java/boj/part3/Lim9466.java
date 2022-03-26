package boj.part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim9466 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] selectedIdx = new int[n + 1];
			boolean[] chosen = new boolean[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j <= n; j++) {
				selectedIdx[j] = Integer.parseInt(st.nextToken());
				chosen[selectedIdx[j]] = true;
			}
			
			boolean[] visited = new boolean[n + 1];
			boolean[] revisited = new boolean[n + 1];
			
			for(int j = 1; j <= n; j++) {
				if(!chosen[j]) {
					boolean[] localVisited = new boolean[n + 1];
					dfs(selectedIdx, j, localVisited, visited, revisited);
				}
			}
			
			int cnt = 0;
			
			for(int j = 1; j <= n; j++) {
				if(visited[j] && !revisited[j]) {
					cnt++;
				}
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int[] selectedIdx, int j, boolean[] localVisited, boolean[] visited, boolean[] revisited) {
		if(localVisited[j]) {
			revisited[j] = true;
		} else {
			visited[j] = true;
			localVisited[j] = true;
		}
		
		if(!revisited[selectedIdx[j]]) {
			dfs(selectedIdx, selectedIdx[j], localVisited, visited, revisited);
		}
	}
}
