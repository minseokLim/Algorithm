package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// max 배열을 이용해서도 해봅시다
public class Lim2156 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n];
		
		for(int i = 0; i < n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		if(n == 1) {
			System.out.println(wine[0]);
			return;
		} else if(n == 2) {
			System.out.println(wine[0] + wine[1]);
			return;
		}
		
		int a = wine[1] + wine[2];
		int b = wine[0] + wine[2];
		int c = wine[0] + wine[1];
		int d = wine[0];
				
		for(int i = 3; i < n; i++) {	
			int tmpA = b + wine[i];
			int tmpB = Math.max(c + wine[i], d + wine[i]);
			int tmpC = Math.max(a, b);
			int tmpD = Math.max(c, d);
			
			a = tmpA;
			b = tmpB;
			c = tmpC;	
			d = tmpD;
		}
		
		System.out.println(Math.max(Math.max(a, b), Math.max(c, d)));
	}
}
