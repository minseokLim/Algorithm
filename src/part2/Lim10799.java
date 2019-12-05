package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim10799 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int stackSize = 1; // 첫번째 파라미터는 무조건 '('로 넘어올 것이므로	
		int answer = 0;
		
		for(int i = 1; i < input.length; i++) {
			if(input[i] == '(') {
				stackSize++;
			} else {
				if(input[i - 1] == '(') {
					stackSize--;
					answer += stackSize;
				} else {
					stackSize--;
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
