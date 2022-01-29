package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim10824 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken());
		String b = st.nextToken();
		long c = Integer.parseInt(st.nextToken());
		String d = st.nextToken();
		
		System.out.println(a * pow(b.length()) + Long.parseLong(b) + c * pow(d.length()) + Long.parseLong(d));
	}
	
	private static int pow(int n) {
		int ret = 1;
		
		for(int i = 0; i < n; i++) {
			ret *= 10;
		}
		
		return ret;
	}
}
