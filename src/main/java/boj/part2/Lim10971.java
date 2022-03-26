package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim10971 {
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			visited[i] = true;
			dfs(cost, visited, i, i, n, 0, 1);
			visited[i] = false;
		}
		
		System.out.println(min);
	}

	private static void dfs(int[][] cost, boolean[] visited, int dest, int depart, int n, int expense, int depth) {
		
		if(depth == n) {
			if(cost[dest][depart] != 0) {
				int totalExpense = expense + cost[dest][depart];
				
				if(totalExpense < min) {
					min = totalExpense;
				}
			}
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i] && cost[dest][i] != 0 && expense + cost[dest][i] < min) {
				visited[i] = true;
				dfs(cost, visited, i, depart, n, expense + cost[dest][i], depth + 1);
				visited[i] = false;
			}
		}
	}
}
