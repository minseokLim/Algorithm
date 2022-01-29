package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1934 {
	public static void main(String[] args)throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(b > a) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			
			sb.append(a * b / gcd(a, b) + "\n");
		}
		
		System.out.println(sb);
	}
	
	private static int gcd(int a, int b) {
		if(a % b == 0) {
			return b;
		}
		
		return gcd(b, a % b);
	}
}
