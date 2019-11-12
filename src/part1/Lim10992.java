package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim10992 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer result = new StringBuffer();
		
		for(int j = 0; j < n - 1; j++) {
			result.append(" ");
		}
		
		result.append("*\n");
		
		for(int i = 1; i < n - 1; i++) {
			
			for(int j = 0; j < n - i - 1; j++) {
				result.append(" ");
			}
			
			result.append("*");
			
			for(int k = 0; k < 2 * i - 1; k++) {
				result.append(" ");
			}
			
			result.append("*\n");
		}
		
		if(n != 1) {
			for(int j = 0; j < 2 * n - 1; j++) {
				result.append("*");
			}
		}
		
		System.out.println(result);
	}
}
