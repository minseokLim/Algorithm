package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2440 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer result = new StringBuffer();
		
		for(int i = n; i >= 0; i--) {
					
			for(int j = 0; j < i; j++) {
				result.append("*");
			}
			result.append("\n");
		}
		
		System.out.println(result);
	}
}
