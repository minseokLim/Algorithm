package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// BOJ 1260
public class Lim1260 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		Set<Integer>[] set = new TreeSet[n + 1];
		
		for(int i = 1; i <= n; i++) {
			set[i] = new TreeSet<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			set[a].add(b);
			set[b].add(a);
		}
		
		StringBuffer sb = new StringBuffer();
		boolean[] visited = new boolean[n + 1];
		
		dfs(set, visited, sb, v);
		
		System.out.println(sb);
		
		sb = new StringBuffer();
		visited = new boolean[n + 1];
		
		bfs(set, visited, sb, v);
		
		System.out.println(sb);
	}

	private static void dfs(Set<Integer>[] set, boolean[] visited, StringBuffer sb, int v) {
		visited[v] = true;
		sb.append(v + " ");
		
		Iterator<Integer> iterator = set[v].iterator();
		
		while(iterator.hasNext()) {
			int next = iterator.next();
			
			if(!visited[next]) {
				dfs(set, visited, sb, next);
			}			
		}
	}

	private static void bfs(Set<Integer>[] set, boolean[] visited, StringBuffer sb, int v) {
		visited[v] = true;
		sb.append(v + " ");
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();		
			
			Iterator<Integer> iterator = set[poll].iterator();
			
			while(iterator.hasNext()) {
				int next = iterator.next();
				
				if(!visited[next]) {
					queue.offer(next);
					visited[next] = true;
					sb.append(next + " ");
				}	
			}
		}
	}
}
