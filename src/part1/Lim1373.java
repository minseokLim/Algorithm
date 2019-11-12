package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Lim1373 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuffer sb = new StringBuffer();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = input.length() - 1; i >= 0; i -= 3) {
			int sum = input.charAt(i) - 48;
			
			try {
				sum += (input.charAt(i - 1) - 48) * 2;
				sum += (input.charAt(i - 2) - 48) * 4;
				stack.add(sum);
			} catch (StringIndexOutOfBoundsException e) {
				stack.add(sum);
				break;
			}			
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
}
