package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _Lim1707 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			@SuppressWarnings("unchecked")
			List<Integer>[] list = new ArrayList[v + 1];
			
			for(int j = 1; j <= v; j++) {
				list[j] = new ArrayList<>();
			}
			
			for(int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				list[b].add(a);
			}
			
			boolean[] visited = new boolean[v + 1];
			dfs(list, visited, 1);
			
			boolean divided = false;
			
			for(int j = 1; j <= v; j++) {
				if(!visited[j]) {
					divided = true;
					break;
				}
			}
			
			if(divided) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
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
