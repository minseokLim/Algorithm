package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1476 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int year = 1;
		
		while(year <= 15 * 28 * 19) {
			if((year - 1) % 15 + 1 == e && (year - 1) % 28 + 1 == s && (year - 1) % 19 + 1 == m) {
				break;
			}
			
			year++;
		}
		
		System.out.println(year);
	}
}
