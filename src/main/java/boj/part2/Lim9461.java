package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim9461 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		int[] nArr = new int[T];
		int max = 0;
		long[] p = new long[101];
		
		for(int i = 0; i < T; i++) {
			nArr[i] = Integer.parseInt(br.readLine());
			
			if(max < nArr[i]) {
				max = nArr[i];
			}
		}
		
		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		p[5] = 2;
		
		for(int i = 6; i <= max; i++) {
			p[i] = p[i - 1] + p[i - 5];
		}
		
		for(int i = 0; i < T; i++) {
			sb.append(p[nArr[i]] + "\n");
		}
		
		System.out.println(sb);
	}
}
