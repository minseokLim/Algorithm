package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lim2331 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(a);
		int tmp = a;
		int sum ;
		
		while(true) {
			
			sum = 0;
			
			while(tmp > 0) {
				sum += power(tmp % 10, p);
				tmp /= 10;
			}
			
			if(!list.contains(sum)) {
				list.add(sum);
				tmp = sum;
			} else {
				break;
			}
			
		}
		
		System.out.println(list.indexOf(sum));
	}
	
	private static int power(int a, int n) {
		int ret = 1;
		
		for(int i = 0; i < n; i++) {
			ret *= a;
		}
		
		return ret;
	}
}
