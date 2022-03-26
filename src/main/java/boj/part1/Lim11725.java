package boj.part1;

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
		boolean[] visit = new boolean[n + 1];
		int[] parents = new int[n + 1];
		
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
		
		bfsMethod(lists, visit, parents);
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 2; i < n + 1; i++) {
			sb.append(parents[i] + "\n");
		}
		
		System.out.println(sb);
	}

	private static void bfsMethod(List<Integer>[] lists, boolean[] visit, int[] parents) {
		visit[1] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int parent = queue.poll();
			List<Integer> tmp = lists[parent];
			
			for(int x : tmp) {
				
				if(!visit[x]) {
					visit[x] = true;
					queue.add(x);
					parents[x] = parent;
				}
			}
		}
	}
}
