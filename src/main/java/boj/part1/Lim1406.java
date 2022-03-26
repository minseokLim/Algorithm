package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Lim1406 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		
		for(int i = 0; i < input.length; i++) {
			left.push(input[i]);
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			switch (cmd) {
				case "L":
					
					if(!left.isEmpty()) {
						right.push(left.pop());
					}
				
					break;
				case "D": 	
					
					if(!right.isEmpty()) {
						left.push(right.pop());
					}
					
					break;		
				case "B": 
					
					if(!left.isEmpty()) {
						left.pop();
					}
					
					break;
				case "P": 
					left.push(st.nextToken().charAt(0));
					break;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < left.size(); i++) {
			sb.append(left.get(i));
		}
		
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		
		System.out.println(sb);
	} 
}
