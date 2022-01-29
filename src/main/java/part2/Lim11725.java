package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim11725 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		@SuppressWarnings("unchecked")
		List<Integer>[] lists = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lists[a].add(b);
			lists[b].add(a);
		}
		
		boolean[] visited = new boolean[n + 1];
		int[] parents = new int[n + 1];
		bfs(lists, visited, parents);
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 2; i <= n; i++) {
			sb.append(parents[i] + "\n");
		}
		
		System.out.println(sb);
	}

	private static void bfs(List<Integer>[] lists, boolean[] visited, int[] parents) {
		visited[1] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int parent = queue.poll();
			
			for(int elem : lists[parent]) {
				if(!visited[elem]) {
					parents[elem] = parent;
					visited[elem] = true;
					queue.add(elem);
				}
			}
		}
	}
}
