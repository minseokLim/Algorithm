package part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lim10952 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			String[] input = br.readLine().trim().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			if(a == 0 && b == 0) break;
			
			sb.append((a + b) + System.getProperty("line.separator"));
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
