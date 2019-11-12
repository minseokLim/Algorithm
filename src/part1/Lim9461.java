package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim9461 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		long[] seq = new long[100];
		seq[0] = 1;
		seq[1] = 1;
		seq[2] = 1;
		seq[3] = 2;
		seq[4] = 2;
		
		for(int i = 5; i < 100; i++) {
			seq[i] = seq[i - 1] + seq[i - 5];		
		}
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(seq[n - 1] + "\n");
		}
		
		System.out.println(sb);
	}
}
