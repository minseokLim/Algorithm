package boj.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lim10808 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int[] cnt = new int['z' - 'a' + 1];
		int len = s.length();
		
		for(int i = 0; i < len; i++) {
			cnt[s.charAt(i) - 97]++;
		}
		
		for(int i = 0; i < cnt.length; i++) {
			bw.write(cnt[i] + " ");
		}
		
		bw.flush();
		br.close();
	}
}
