package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lim2667 {
	private static int[] di = {0, 0, 1, -1};
	private static int[] dj = {1, -1, 0, 0};
	private static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[n][n];
		boolean[][] visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j = 0; j < n; j++) {
				if(input[j] == '1') {
					map[i][j] = true;
				}
			}
		}
		
		int vCnt = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] && !visited[i][j]) {
					cnt = 0;
					dfs(map, visited, i, j, n);
					vCnt++;
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(vCnt);
		
		for(int elem : list) {
			System.out.println(elem);
		}
	}

	private static void dfs(boolean[][] map, boolean[][] visited, int i, int j, int n) {
		visited[i][j] = true;
		cnt++;
		
		for(int k = 0; k < 4; k++) {
			int nextI = i + di[k];
			int nextJ = j + dj[k];
			
			if(nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < n) {
				if(map[nextI][nextJ] && !visited[nextI][nextJ]) {
					dfs(map, visited, nextI, nextJ, n);
				}
			}
		}
	}
}
