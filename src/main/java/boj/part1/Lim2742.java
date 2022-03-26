package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2742 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer result = new StringBuffer();
		
		for(int i = n; i > 0; i--) {
			result.append(i + "\n");
		}
		
		System.out.println(result);
	}
}
