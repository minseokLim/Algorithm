package part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim2004 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int two = get2(n) - get2(n - m) - get2(m);
		int five = get5(n) - get5(n - m) - get5(m);
		
		System.out.println(Math.min(two, five));
	}
	
	// n 팩토리얼에 있는 2의 갯수를 구하는 함수
	private static int get2(int n) {
		int tmp = n;
		int cnt = 0;
		
		while(tmp > 0) {
			cnt += tmp/2;
			tmp /= 2;
		}
		
		return cnt;
	}
	
	// n 팩토리얼에 있는 5의 갯수를 구하는 함수
	private static int get5(int n) {
		int tmp = n;
		int cnt = 0;
		
		while(tmp > 0) {
			cnt += tmp/5;
			tmp /= 5;
		}
		
		return cnt;
	}
}