package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1783 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if(n == 1 || m == 1 || (n < 3 && m < 3)) {
			System.out.println(1);
		} else if(n == 2 && m <= 8) {
			System.out.println((m + 1) / 2);
		} else if(n == 2) {
			System.out.println(4);
		} else if(m <= 4) {
			System.out.println(m);
		} else if(m <= 6) {
			System.out.println(4);
		} else {
			System.out.println(m - 2);
		}
	}
}
