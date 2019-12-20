package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Lim2873 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] scores = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < c; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuffer sb = new StringBuffer();
		
		if((r & 1) == 1) {
			makeZigZag('R', 'L', 'D', c, r, sb);
		}
	}

	private static void makeZigZag(char char1, char char2, char char3, int c, int r, StringBuffer sb) {
//		char mark
	}
}
