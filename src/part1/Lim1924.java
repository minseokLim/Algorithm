package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lim1924 {
	public static void main(String[] args) throws Exception {
		final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		final String[] weeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int month = Integer.parseInt(inputs[0]);
		int day = Integer.parseInt(inputs[1]);
		int n = 0;
		
		for(int i = 0; i < month - 1; i++) {
			n += days[i];
		}
		
		n+= day;
		
		System.out.println(weeks[n % 7]);
	}
}
