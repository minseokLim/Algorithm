package boj.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Lim10951 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;	
		while((input = br.readLine()) != null) {	
			System.out.println(Stream.of(input.split(" ")).mapToInt(Integer::parseInt).sum());
		}	
	}
}
