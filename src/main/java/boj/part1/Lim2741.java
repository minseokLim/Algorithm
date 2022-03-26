package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2741 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer result = new StringBuffer();
		
		for(int i = 1; i <= n; i++) {
			result.append(i + "\n");
		}
		
		System.out.println(result);
	}
}
