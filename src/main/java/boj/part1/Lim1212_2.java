package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim1212_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		if("0".equals(input)) {
			System.out.println(0);
			return;
		}
		
		int len = input.length();
		String[] arr1 = {"", "1", "10", "11", "100", "101", "110", "111"};
		String[] arr2 = {"000", "001", "010", "011", "100", "101", "110", "111"};
		StringBuffer sb = new StringBuffer();
		
		sb.append(arr1[input.charAt(0) - 48]);
		
		for(int i = 1; i < len; i++) {
			int n = input.charAt(i) - 48;
			sb.append(arr2[n]);
		}
		
		System.out.println(sb);
	}
}
