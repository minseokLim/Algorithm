package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim2609 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = getGcd(a, b);
		int lcm = a * b / gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
	}

	private static int getGcd(int a, int b) {
		if(a < b) {
			return getGcd(b, a);
		}
		
		if(a % b == 0) {
			return b;
		}
		return getGcd(b, a % b);
	}
}
