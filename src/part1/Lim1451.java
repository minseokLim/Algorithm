package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1451 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] rectangle = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < m; j++) {
				rectangle[i][j] = input.charAt(j) - 48;
			}			
		}
		
		long max = calculate(n, m, rectangle, 0, 0, true);
		
		System.out.println(max);
	}

	private static long calculate(int n, int m, int[][] rectangle, int startI, int startJ, boolean first) {
		long max = Long.MIN_VALUE;
		
		for(int i = startI; i < n - 1; i++) {
			
			long a = 0;
			long aa = 0;
			for(int j = startI; j <= i; j++) {
				
				for(int k = startJ; k < m; k++) {
					a += rectangle[j][k];
				}
			}
			
			if(first) {
				aa = calculate(i + 1, m, rectangle, 0, 0, false);
			}
			
			long b = 0;
			long bb = 0;
			
			for(int j = i + 1; j < n; j++) {
				
				for(int k = startJ; k < m; k++) {
					b += rectangle[j][k];
				}
			}
			
			if(first) {
				bb = calculate(n, m, rectangle, i + 1, 0, false);
			}
			
			long tmp;
			
			if(first) {
				tmp = Math.max(a * bb, b * aa);			
			} else {
				tmp = a * b;
			}
			
			if(max < tmp) {
				max = tmp;
			}
		}
		
		for(int i = startJ; i < m - 1; i++) {
			
			long a = 0;
			long aa = 0;
			
			for(int j = startJ; j <= i; j++) {
				
				for(int k = startI; k < n; k++) {
					a += rectangle[k][j];
				}
			}
			
			if(first) {
				aa = calculate(n, i + 1, rectangle, 0, 0, false);
			}
			
			long b = 0;
			long bb = 0;
			
			for(int j = i + 1; j < m; j++) {
				
				for(int k = startI; k < n; k++) {
					b += rectangle[k][j];
				}
			}
			
			if(first) {
				bb = calculate(n, m, rectangle, 0, i + 1, false);
			}
			
			long tmp;
			
			if(first) {
				tmp = Math.max(a * bb, b * aa);			
			} else {
				tmp = a * b;
			}
			
			if(max < tmp) {
				max = tmp;
			}
		}
		
		return max;
	}	
}
