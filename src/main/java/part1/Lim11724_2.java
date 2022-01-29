package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim11724_2 {
	
	private static boolean[][] matrix;
	private static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		matrix = new boolean[n + 1][n + 1];
		visit = new boolean[n + 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			matrix[a][b] = true;
			matrix[b][a] = true;
		}
		
		int idx;
		
		while((idx = findRemainIdx()) != -1) {
			dfsMethod(idx);
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	private static void dfsMethod(int s) {
		visit[s] = true;
		
		for(int i = 1; i < matrix[s].length; i++) {
			
			if(!visit[i] && matrix[s][i]) {
				dfsMethod(i);
			}
		}
	}
	
	private static int findRemainIdx() {
		int ret = -1;
		
		for(int i = 1; i < visit.length; i++) {
			
			if(!visit[i]) {
				ret = i;
				break;
			}
		}
		
		return ret;
	}
}
