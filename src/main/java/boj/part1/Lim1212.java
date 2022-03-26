package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim1212 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int len = input.length();
		StringBuffer sb = new StringBuffer();
		
		if("0".equals(input)) {
			System.out.println(0);
			return;
		}
		
		for(int i = 0; i < len; i++) {
			int n = input.charAt(i) - 48;
			StringBuffer tmp = new StringBuffer();
			
			while((i != 0 && tmp.length() < 3) || n > 0) {
				tmp.insert(0, n % 2);
				n /= 2;
			}
						
			sb.append(tmp);
		}
		
		System.out.println(sb);
	}
}
