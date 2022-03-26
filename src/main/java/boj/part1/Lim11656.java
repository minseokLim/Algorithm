package boj.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Lim11656 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		String[] arr = new String[s.length()];
		
		for(int i = 0; i < s.length(); i++) {
			arr[i] = s.substring(i);
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			bw.write(arr[i] + "\n");
		}
		
		bw.flush();
	}
}
