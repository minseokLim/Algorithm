package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim2089 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n == 0) {
			System.out.println(0);
			return;
		}
		
		StringBuffer sb = new StringBuffer();
		
		while(n != 0) {
			int q = n / -2;
			int r = n % -2;
			
			if(r < 0) {
				q++;
				r += 2;
			}
			
			sb.append(r);
			
			n = q;
		}
		
		System.out.println(sb.reverse());
	}
}
