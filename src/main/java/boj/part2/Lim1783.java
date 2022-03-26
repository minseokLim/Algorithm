package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1783 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if(n == 1 || m == 1 || (n <= 2 && m <= 2)) {
			System.out.println(1);
		} else if(n == 2) {
			int temp = (m + 1) / 2;
			temp = temp > 4 ? 4: temp;
			System.out.println(temp);
		} else if(m < 7) {
			int temp = m;
			temp = temp > 4 ? 4: temp;
			System.out.println(temp);
		} else {
			System.out.println(m - 2);
		}
	}
}
