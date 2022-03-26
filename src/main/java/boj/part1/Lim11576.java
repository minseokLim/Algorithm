package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Lim11576 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int input = 0;
		int multiplyer = power(a, m - 1);
		
		for(int i = 0; i < m; i++) {
			input += Integer.parseInt(st.nextToken()) * multiplyer;
			multiplyer /= a;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		StringBuffer sb = new StringBuffer();
		
		while(input > 0) {
			stack.push(input % b);
			input /= b;
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		
		System.out.println(sb);
	}
	
	private static int power(int a, int b) {
		int ret = 1;
		
		for(int i = 0; i < b; i++) {
			ret *= a;
		}
		
		return ret;
	}
} 
