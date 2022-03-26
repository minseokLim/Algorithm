package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim9461_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		long[] seq = new long[100];
		seq[0] = 1;
		seq[1] = 1;
		seq[2] = 1;
		
		for(int i = 3; i < 100; i++) {
			seq[i] = seq[i - 2] + seq[i - 3];		
		}
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(seq[n - 1] + "\n");
		}
		
		System.out.println(sb);
	}
}
