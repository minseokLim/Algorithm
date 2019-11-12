package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lim1260_2 {
	
	private static boolean[][] matrix;
	private static boolean[] visit;
	private static Queue<Integer> queue = new LinkedList<Integer>();
	private static StringBuffer dfs = new StringBuffer();
	private static StringBuffer bfs = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		matrix = new boolean[n + 1][n + 1];
		visit = new boolean[n + 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			matrix[a][b] = true;
			matrix[b][a] = true;
		}
		
		dfsMethod(v);		
		
		visit = new boolean[n + 1];		
		visit[v] = true;
		bfs.append(v + " ");
		bfsMethod(v);
		
		System.out.println(dfs);
		System.out.println(bfs);
	}
	
	private static void dfsMethod(int v) {
		visit[v] = true;
		dfs.append(v + " ");
		
		for(int i = 1; i < matrix[v].length; i++) {
			
			if(!visit[i] && matrix[v][i]) {
				dfsMethod(i);
			}
		}
	}
	
	private static void bfsMethod(int v) {
		
		for(int i = 1; i < matrix[v].length; i++) {
			
			if(!visit[i] && matrix[v][i]) {
				visit[i] = true;
				bfs.append(i + " ");
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			bfsMethod(queue.poll());
		}
	}
}
