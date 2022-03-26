package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim1967 {
	private static int diameter = 0;
	private static int lineEnd = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		@SuppressWarnings("unchecked")
		List<Line>[] lists = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			lists[i] = new ArrayList<Line>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			lists[a].add(new Line(b, len));
			lists[b].add(new Line(a, len));
		}
		
		boolean[] visited = new boolean[n + 1];
		dfs(lists, visited, lineEnd, 0);
		
		visited = new boolean[n + 1];
		dfs(lists, visited, lineEnd, 0);
		
		System.out.println(diameter);
	}
	
	private static void dfs(List<Line>[] lists, boolean[] visited, int i, int length) {
		visited[i] = true;
		
		if(length > diameter) {
			diameter = length;
			lineEnd = i;
		}
		
		for(Line line : lists[i]) {
			int dest = line.getDest();
			int len = line.getLen();
			
			if(!visited[dest]) {
				dfs(lists, visited, dest, length + len);
			}
		}
	}

	private static class Line {
		private int dest;
		private int len;
		
		public Line(int dest, int len) {
			this.dest = dest;
			this.len = len;
		}
		
		public int getDest() {
			return dest;
		}
		
		public int getLen() {
			return len;
		}
	}
}
