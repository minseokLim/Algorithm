package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim11726_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long answer = 0;
		int q = n / 2;
		int r = n % 2;
				
		for(int i = q ; i >= 0; i--) {
			answer += multiplyUntil(i + r, i) / factorial(r);
			r = r + 2;
		}
		
		System.out.println(answer % 10007);
	}
	
	private static long factorial(int n) {
		long ret = 1;
		
		while(n != 1 && n != 0) {
			ret *= n--;
		}
		
		return ret;
	}
	
	private static long multiplyUntil(int a, int b) {
		long ret = 1;
		
		while(a > b) {
			ret *= a--;
		}
		
		return ret;
	}
}
