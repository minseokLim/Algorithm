package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim1406_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		Stack left = new Stack(input);
		Stack right = new Stack();
		
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
	
	static class Stack {
		private char[] stack = new char[600000];
		private int cursor = 0;
		
		public Stack(char[] input) {
			System.arraycopy(input, 0, stack, 0, input.length);
			cursor = input.length;
		}

		public Stack() {}
		
		public void push(char c) {
			stack[cursor] = c;
			cursor++;
		}
		
		public char pop() {
			char ret = stack[--cursor];
			stack[cursor] = '\u0000';
			return ret;
		}
		
		public boolean isEmpty() {
			if(cursor == 0) {
				return true;
			} else {
				return false;
			}
		}
		
		public char get(int i) {
			return stack[i];
		}
		
		public int size() {
			return cursor;
		}
	}
}