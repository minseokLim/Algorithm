package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim1167_2 {
	private static int diameter = 0;
	private static int start = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		
		@SuppressWarnings("unchecked")
		List<Integer>[] lists = new ArrayList[v + 1];
				
		for(int i = 1; i <= v; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());		
			int m;
			
			while((m = Integer.parseInt(st.nextToken())) != -1) {
				lists[n].add(m);
			}
		}
		
		boolean[] visit = new boolean[v + 1];
		dfsMethod(lists, visit, start, v, 0);
		visit = new boolean[v + 1];
		dfsMethod(lists, visit, start, v, 0);
		
		System.out.println(diameter);
	}
	

	private static void dfsMethod(List<Integer>[] lists, boolean[] visit, int i, int v, int distance) {
		visit[i] = true;
		
		if(distance > diameter) {
			diameter = distance;
			start = i;
		}
		
		int realSize = lists[i].size() / 2;
		
		for(int j = 0; j < realSize; j++) {
			
			int idx = lists[i].get(2 * j);
			
			if(!visit[idx]) {
				dfsMethod(lists, visit, idx, v, distance + lists[i].get(2 * j + 1));
			}
		}
	}
}
