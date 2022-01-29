package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2445 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer result = new StringBuffer();
		
		for(int i = 0; i < 2 * n - 1; i++) {		
			int no = Math.abs(n - (i + 1));
			for(int j = 0; j < n - no; j++) {
				result.append("*");
			}
			
			for(int k = 0; k < 2 * no; k++) {
				result.append(" ");
			}
			
			for(int j = 0; j < n - no; j++) {
				result.append("*");
			}
			
			result.append("\n");
		}
		
		System.out.println(result);
	}
}
