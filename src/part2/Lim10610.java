package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lim10610 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] numArr = br.readLine().toCharArray();
		int sum = 0;
		
		for(int i = 0; i < numArr.length; i++) {
			sum += numArr[i] - '0';
		}
		
		Arrays.sort(numArr);
		
		if(sum % 3 == 0 && numArr[0] == '0') {
			StringBuffer sb = new StringBuffer();
			
			for(int i = numArr.length - 1; i >= 0; i--) {
				sb.append(numArr[i]);
			}
			
			System.out.println(sb);
			
		} else {
			System.out.println(-1);
		}
	}
}
