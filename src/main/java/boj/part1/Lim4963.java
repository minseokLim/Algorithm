package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim4963 {
	private static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	private static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringBuffer sb = new StringBuffer();
		
		while(!(input = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(input);
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			boolean[][] map = new boolean[h + 2][w + 2];
			
			for(int i = 1; i <= h; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 1; j <= w; j++) {
					
					if(st.nextToken().equals("1")) {
						map[i][j] = true;
					} 
				}
			}
			
			int cnt = 0;
			
			for(int i = 1; i <= h; i++) {
				
				for(int j = 1; j <= w; j++) {
					
					if(map[i][j]) {
						dfs(map, i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb);
	}

	private static void dfs(boolean[][] map, int i, int j) {
		map[i][j] = false;
		
		for(int k = 0; k < 8; k++) {
			
			if(map[i + dx[k]][j + dy[k]]) {
				dfs(map, i + dx[k], j + dy[k]);
			}
		}
	}
}
