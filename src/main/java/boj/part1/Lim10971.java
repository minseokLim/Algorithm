package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim10971 {
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] w = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			boolean[] visited = new boolean[n];
			travel(i, i, w, visited, n, 0, 1);
		}
		
		System.out.println(min);
	}

	private static void travel(int departure, int visitIdx, int[][] w, boolean[] visited, int n, int cost, int depth) {
		visited[visitIdx] = true;
		
		if(depth == n) {
			if(w[visitIdx][departure] != 0) {
				cost += w[visitIdx][departure];
				if(cost < min) {
					min = cost;
				}
			}
			
			return;
			
		}
		
		for(int i = 0; i < n; i++) {
			
			if(w[visitIdx][i] != 0 && !visited[i]) {
				boolean[] newVisited = new boolean[n];
				System.arraycopy(visited, 0, newVisited, 0, n);
				travel(departure, i, w, newVisited, n, cost + w[visitIdx][i], depth + 1);
			}
		}
	}
}
