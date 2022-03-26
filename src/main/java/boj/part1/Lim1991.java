package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim1991 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] nodeRel = new char[2][n];
		
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			int idx = input.charAt(0) - 65;
			nodeRel[0][idx] = input.charAt(2);
			nodeRel[1][idx] = input.charAt(4);
		}
		StringBuffer answer = new StringBuffer();
		method1(nodeRel, 'A', answer);
		answer.append("\n");
		method2(nodeRel, 'A', answer);
		answer.append("\n");
		method3(nodeRel, 'A', answer);
		
		System.out.println(answer);
	}

	private static void method1(char[][] nodeRel, char parent, StringBuffer answer) {
		answer.append(parent);
		int idx = parent - 65;
		
		if(nodeRel[0][idx] != '.') {
			method1(nodeRel, nodeRel[0][idx], answer);
		}
		
		if(nodeRel[1][idx] != '.') {
			method1(nodeRel, nodeRel[1][idx], answer);
		}
	}
	
	private static void method2(char[][] nodeRel, char parent, StringBuffer answer) {
		int idx = parent - 65;
		
		if(nodeRel[0][idx] != '.') {
			method2(nodeRel, nodeRel[0][idx], answer);
		}
		
		answer.append(parent);
		
		if(nodeRel[1][idx] != '.') {
			method2(nodeRel, nodeRel[1][idx], answer);
		}
	}
	
	private static void method3(char[][] nodeRel, char parent, StringBuffer answer) {
		int idx = parent - 65;
		
		if(nodeRel[0][idx] != '.') {
			method3(nodeRel, nodeRel[0][idx], answer);
		}
		
		if(nodeRel[1][idx] != '.') {
			method3(nodeRel, nodeRel[1][idx], answer);
		}
		
		answer.append(parent);		
	}
}
