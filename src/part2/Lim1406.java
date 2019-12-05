package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Lim1406 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		char[] input = br.readLine().toCharArray();
		
		for(int i = 0; i < input.length; i++) {
			left.push(input[i]);
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String cmd = br.readLine();
			
			try {
				switch (cmd) {
				case "L":
					right.push(left.pop());
					break;
				case "D":
					left.push(right.pop());
					break;
				case "B":
					left.pop();
					break;
				default:
					left.push(cmd.charAt(2));
					break;
				}
			} catch (EmptyStackException e) {
				continue;
			}			
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < left.size(); i++) {
			sb.append(left.get(i));
		}
		
		while(!right.empty()) {
			sb.append(right.pop());
		}
		
		System.out.println(sb);
	}
}
