package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim10971_2 {
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
			
			// dfs이기 때문에 하나의 탐색이 다 끝나기 전까진 다른 탐색을 하지 않는다. 따라서 각각의 재귀호출 이후 visited배열만 다시 원복을 시켜주면 굳이 배열을 복사할 필요가 없어진다.
			// 또한 현재의 min값보다 더 큰 비용이 들것으로 예상되는 곳으로 굳이 탐색을 더 진행할 필요가 없다.
			if(w[visitIdx][i] != 0 && !visited[i] && cost + w[visitIdx][i] < min) {
				travel(departure, i, w, visited, n, cost + w[visitIdx][i], depth + 1);
				visited[i] = false;
			}
		}
	}
}
