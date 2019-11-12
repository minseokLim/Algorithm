package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim9465 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] scores = new int[2][n];
			
			StringTokenizer st0 = new StringTokenizer(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) {
				scores[0][j] = Integer.parseInt(st0.nextToken());
			}
			
			for(int j = 0; j < n; j++) {
				scores[1][j] = Integer.parseInt(st1.nextToken());
			}
			
			int a = scores[0][0];
			int b = scores[1][0];
			
			for(int j = 1; j < n - 1; j++) {
				int tmpA;
				int tmpB;
				
				tmpA = Math.max(a, b + scores[0][j]);
				tmpB = Math.max(b, a + scores[1][j]);
				
				a = tmpA;
				b = tmpB;
			}
			
			if(n == 1) {
				sb.append(Math.max(a, b) + "\n");
			} else {
				sb.append(Math.max(a + scores[1][n - 1], b + scores[0][n - 1]) + "\n");
			}
		}
		
		System.out.println(sb);
	}
}
