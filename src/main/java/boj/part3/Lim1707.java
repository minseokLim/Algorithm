package boj.part3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim1707 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			@SuppressWarnings("unchecked")
			List<Integer>[] lists = new ArrayList[v + 1];
			int[] color = new int[v + 1];
			
			for(int j = 1; j <= v; j++) {
				lists[j] = new ArrayList<Integer>();
			}
			
			for(int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				lists[a].add(b);
				lists[b].add(a);
			}
			
			boolean bipartite = true;
			
			for(int j = 1; j <= v; j++) {
				if(color[j] == 0) {
					if(!bfsCheck(lists, color, j)) {
						bipartite = false;						
						break;
					};
				}
			}	
			
			if(bipartite) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
	}

	private static boolean bfsCheck(List<Integer>[] lists, int[] color, int j) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(j);
		color[j] = 1;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			for(int elem : lists[n]) {
				if(color[elem] == 0) {
					queue.offer(elem);
					color[elem] = color[n] * -1;
				} else if(color[elem] != color[n] * -1) {
					return false;
				}
			}
		}
		
		return true;
	}
}
