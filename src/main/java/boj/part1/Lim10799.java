package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim10799 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int cnt = 0;
		int stack = 0;
		
		for(int i = 0; i < input.length(); i++) {
			char x = input.charAt(i);
			
			switch (x) {
			case '(':
				if(input.charAt(i + 1) ==')') {
					cnt += stack;
					i++;
				} else {
					cnt++;
					stack++;
				}	

				break;
			case ')':
				stack--;
				break;
			}
		}
		
		System.out.println(cnt);
	}
}
