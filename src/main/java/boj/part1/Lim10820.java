package boj.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lim10820 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		String str;
		
		while((str = br.readLine()) != null) {
			
			int lower = 0;
			int upper = 0;
			int number = 0;
			int space = 0;
			
			for(int i = 0; i < str.length(); i++) {
				char x = str.charAt(i);
				
				if(x >= 97 && x <= 122) {
					lower++;
				} else if(x >= 65 && x <= 90) {
					upper++;
				} else if(x >= 48 && x <= 57) {
					number++;
				} else if(x == ' ') {
					space++;
				}
			}
			
			System.out.println(lower + " " + upper + " " + number + " " + space);
		}
		
		bw.flush();
	}
}
