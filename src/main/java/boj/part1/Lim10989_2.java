package boj.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lim10989_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int[] cnt = new int[10001];
		
		for(int i = 0; i < n; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}
				
		for(int i = 1; i <= 10000; i++) {
			
			for(int j = 0; j < cnt[i]; j++) {
				bw.write(i + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
