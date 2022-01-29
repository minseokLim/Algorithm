package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim9613 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			
			for(int j = 0; j < n - 1; j++) {
				
				for(int k = j + 1; k < n; k++) {
					sum += gcd(arr[j], arr[k]);
				}
			}
			
			sb.append(sum + "\n");
		}
		
		System.out.println(sb);
	}
	
	private static int gcd(int a, int b) {
		
		if(b > a) return gcd(b, a);	
		if(a % b == 0) return b;
		
		return gcd(b, a % b);
	}
}
