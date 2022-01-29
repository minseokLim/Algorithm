package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim11005 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		
		while(t >= b) {
			int n = t % b;
			t /= b;

			sb.insert(0, getChar(n));
		}
		
		sb.insert(0, getChar(t));
		
		System.out.println(sb);
	}
	
	private static char getChar(int n) {
		
		if(n > 9) {
			return (char) (n + 55);
		} else {
			return (char) (n + 48);
		}
	}
}
