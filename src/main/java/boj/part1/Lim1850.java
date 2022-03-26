package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1850 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		if(b > a) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		
		long n = gcd(a, b);
		
		for(int i = 0; i < n; i++) {
			sb.append("1");
		}
		
		System.out.println(sb);
	}
	
	private static long gcd(long a, long b) {
		if(a % b == 0) return b;
		
		return gcd(b, a % b);
	}
}
