package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim10610 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int[] cnt = new int[10];
		boolean zeroExist = false;
		int sum = 0;
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < input.length; i++) {
			
			if(input[i] == '0') {
				zeroExist = true;
			}
			
			sum += input[i] - 48;
			cnt[input[i] - 48]++;
		}
		
		if(!zeroExist || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		
		for(int i = 9; i >= 0; i--) {
			
			for(int j = 0; j < cnt[i]; j++) {
				sb.append(i);
			}
		}
		
		System.out.println(sb);
	}
}
