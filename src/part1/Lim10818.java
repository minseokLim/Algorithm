package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim10818 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int min = Integer.parseInt(inputs[0]);
		int max = Integer.parseInt(inputs[0]);
		
		for(int i = 1; i < l; i++) {
			int n = Integer.parseInt(inputs[i]);
			
			if(n < min) {
				min = n;
			} else if(n > max) {
				max = n;
			}
		}
		
		System.out.println(min + " " + max);
	}
}
