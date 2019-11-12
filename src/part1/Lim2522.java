package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2522 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer result = new StringBuffer();
		
		for(int i = 0; i < 2 * n - 1; i++) {	
			int no = Math.abs(n - (i + 1));
			
			for(int j = 0; j < no; j++) {
				result.append(" ");
			}
			
			for(int k = 0; k < n - no; k++) {
				result.append("*");
			}
			
			result.append("\n");
		}
		
		System.out.println(result);
	}
}
