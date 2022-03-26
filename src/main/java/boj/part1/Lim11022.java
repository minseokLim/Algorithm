package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim11022 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer result = new StringBuffer();
		
		for(int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);
			result.append("Case #" + (i + 1) + ": " + a + " + " + b + " = " + (a + b) + "\n");
		}
		
		System.out.println(result);
	}
}
