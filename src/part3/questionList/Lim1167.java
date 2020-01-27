package part3.questionList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim1167 {
	private static int diameter = 0;
	private static int lineEnd = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		
		@SuppressWarnings("unchecked")
		List<Line>[] lists = new ArrayList[v + 1];
		
		for(int i = 1; i <= v; i++) {
			lists[i] = new ArrayList<Line>();
		}
		
		for(int i = 0; i < v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			while(st.hasMoreTokens()) {
				int b = Integer.parseInt(st.nextToken());
				
				if(b == -1) break;
				
				int len = Integer.parseInt(st.nextToken());
				lists[a].add(new Line(b, len));
			}
		}
		
		boolean[] visited = new boolean[v + 1];
		dfs(lists, visited, lineEnd, 0);
		
		visited = new boolean[v + 1];
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
				// 트리는 사이클이 없는 무방향 그래프
				// 트리에서는 어떤 두 노드를 선택해도 둘 사이에 경로가 항상 하나만 존재하게 된다라고 한다 -> visited를 굳이 false로 원복시킬 이유가 없음. 
				// visited[dest] = false; 
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
