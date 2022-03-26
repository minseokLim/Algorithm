package boj.part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2011 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		
		if(input[0] == '0') {
			System.out.println(0);
			return;
		}
		
		int length = input.length;
		char[] pwd = new char[length + 1];
		System.arraycopy(input, 0, pwd, 1, length);
		
		int[] cnt = new int[length + 1];
		cnt[0] = 1;
		cnt[1] = 1;
				
		for(int i = 2; i <= length; i++) {
			switch (pwd[i - 1]) {
			case '1':
				if(pwd[i] == '0') {
					cnt[i] = cnt[i - 2];
				} else {
					cnt[i] = (cnt[i - 1] + cnt[i - 2]) % 1000_000;
				}
				break;
			case '2':
				if(pwd[i] >= '1' && pwd[i] <= '6') {
					cnt[i] = (cnt[i - 1] + cnt[i - 2]) % 1000_000;
				} else if(pwd[i] == '0') {
					cnt[i] = cnt[i - 2];
				} else {
					cnt[i] = cnt[i - 1];
				}
				break;
			default:
				if(pwd[i] == '0') {
					System.out.println(0);
					return;
				} else {
					cnt[i] = cnt[i - 1];
				}
				break;
			}
		}
		
		System.out.println(cnt[length]);
	}
}
