package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim11720 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		int sum = 0;
		
		String[] inputs = br.readLine().split("");
		
		for(String input : inputs) {
			sum += Integer.parseInt(input);
		}
		
		System.out.println(sum);
	}
}
