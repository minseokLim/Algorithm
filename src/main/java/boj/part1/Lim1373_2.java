package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim1373_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer input = new StringBuffer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int r = input.length() % 3;
		
		if(r == 1) {
			input.insert(0, "00");
		} else if(r == 2) {
			input.insert(0, "0");
		}
		
		for(int i = 0; i < input.length(); i += 3) {
			int sum = (input.charAt(i) - 48) * 4;		
			sum += (input.charAt(i + 1) - 48) * 2;
			sum += (input.charAt(i + 2) - 48);
			
			sb.append(sum);
		}
		
		System.out.println(sb);
	}
}
