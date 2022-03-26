package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim11021 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer result = new StringBuffer();
		
		for(int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			result.append("Case #" + (i + 1) + ": " + (Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1])) + "\n");
		}
		
		System.out.println(result);
	}
}
