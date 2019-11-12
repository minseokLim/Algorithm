package part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
import java.util.Stack;

public class Lim9012 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			String ps = br.readLine();
			Stack<Boolean> stack = new Stack<>();
			
			try {
				
				for(int j = 0; j < ps.length(); j++) {
					char c = ps.charAt(j);
					
					if(c == '(') {
						stack.push(true);
					} else {
						stack.pop();
					}
				}
				
				if(stack.size() == 0) {
					bw.write("YES \n");
				} else {
					bw.write("NO \n");
				}			
			} catch (EmptyStackException e) {
				bw.write("NO \n");
			}
		}
		
		bw.flush();
	}
}
