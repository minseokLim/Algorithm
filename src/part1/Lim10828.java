package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Lim10828 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			try {
				
				if(cmd.equals("push")) {
					stack.push(Integer.parseInt(st.nextToken()));
				} else if(cmd.equals("pop")) {
					System.out.println(stack.pop());
				} else if(cmd.equals("size")) {
					System.out.println(stack.size());
				} else if(cmd.equals("empty")) {
					
					if(stack.size() == 0) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
				} else {
					System.out.println(stack.peek());
				}
			} catch (EmptyStackException e) {
				System.out.println(-1);
			}		
		}
	}
}
