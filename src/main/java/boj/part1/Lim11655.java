package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim11655 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < input.length(); i++) {
			char x = input.charAt(i);
			
			if(x >= 97 && x <= 122) {
				char y = (char) (x + 13 <= 122 ? x + 13 : x - 13);				
				sb.append(y);
			} else if(x >= 65 && x <= 90) {
				char y = (char) (x + 13 <= 90 ? x + 13 : x - 13);				
				sb.append(y);
			} else {
				sb.append(x);
			}
		}
		
		System.out.println(sb);
	}
}
