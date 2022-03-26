package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim2745 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		int multiplyer = 1;
		int answer = 0;
		
		for(int i = n.length() - 1; i >= 0; i--) {
			answer += getNumber(n.charAt(i)) * multiplyer;
			multiplyer *= b;
		}
		
		System.out.println(answer);
	}
	
	private static int getNumber(char c) {
		
		if(c >= 65) {
			return c - 55;
		} else {
			return c - 48;
		}
	}
}
