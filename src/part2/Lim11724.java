package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim11724 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		List<Integer>[] list = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		boolean[] visited = new boolean[n + 1];
		int cnt = 0;
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				dfs(list, visited, i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	private static void dfs(List<Integer>[] list, boolean[] visited, int i) {
		visited[i] = true;
		
		for(int next : list[i]) {
			if(!visited[next]) {
				dfs(list, visited, next);
			}
		}
	}
}
