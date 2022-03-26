// https://mattlee.tistory.com/50

package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1261 {	
	private static int[] di = {1, 0, -1, 0};
	private static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		if(m == 1 && n == 1) {
			br.readLine();
			System.out.println(0);
			return;
		}
		
		boolean[][] visited = new boolean[n][m];
		short[][][][] wallInfo = new short[n][m][n][m];
		
		short[][] map = new short[n][m];
		
		for(int i = 0; i < n; i++) {
			char[] row = br.readLine().toCharArray();
			
			for(int j = 0; j < m; j++) {
				map[i][j] = (short) (row[j] - 48);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < n; k++) {
					for(int h = 0; h < m; h++) {
						wallInfo[i][j][k][h] = 10000;
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < 4; k++) {
					int newI = i + di[k];
					int newJ = j + dj[k];
					
					if(newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
						wallInfo[i][j][newI][newJ] = map[newI][newJ];
					}
				}
			}
		}
		
		visited[0][0] = true;
		short[][] distance = wallInfo[0][0];
		
		while(true) {
			int minI = Integer.MAX_VALUE;
			int minJ = Integer.MAX_VALUE;
			int min = Integer.MAX_VALUE;
			
			for(int a = 0; a < n; a++) {
				for(int b = 0; b < m; b++) {	
					if(!visited[a][b] && distance[a][b] < min) {
						min = distance[a][b];
						minI = a;
						minJ = b;
					}
				}
			}
			
			if(minI == n - 1 && minJ == m - 1) {
				break;
			}
			
			visited[minI][minJ] = true;
			
			for(int a = 0; a < n; a++) {
				for(int b = 0; b < m; b++) {
					if(!visited[a][b]) {
						if(distance[a][b] > distance[minI][minJ] + wallInfo[minI][minJ][a][b]) {
							distance[a][b] = (short) (distance[minI][minJ] + wallInfo[minI][minJ][a][b]);
						}
					}				
				}
			}
		}
		
		System.out.println(distance[n - 1][m - 1]);
		
//		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//
//		System.out.println("used memory is " + (used / 1024 / 1024) + " Mbytes");
	}
}
