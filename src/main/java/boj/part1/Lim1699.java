package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim1699 {
	
private static int[] minArr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		minArr = new int[n + 1];
		System.out.println(findMin(n));
	}
	
	private static int findMin(int n) {
		
		if(minArr[n] != 0) {
			return minArr[n];
		}
		
		int min = n;
		int i = (int) Math.sqrt(n);
		
		while(i > 1) {
			int q = n / (i * i);
			int m = n % (i * i);
			int tmp = q + findMin(m);
			if(min > tmp) {
				min = tmp;
			}
			
			i--;
		}
		
		minArr[n] = min;
		return min;
	}
}
