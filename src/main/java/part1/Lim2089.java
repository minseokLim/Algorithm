package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Lim2089 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n == 0) {
			System.out.println(0);
			return;
		}
		
		StringBuffer sb = new StringBuffer();
		Stack<Integer> stack = new Stack<Integer>();
		
		while(n != 0) {
			int r = n % (-2);
			
			if(r < 0) {
				r = -r;
				n = n / (-2) + 1;
			} else {
				n /= (-2);
			}
			
			stack.push(r);
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
}
