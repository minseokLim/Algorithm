package part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lim11652_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] cards = new long[n];
		
		for(int i = 0; i < n; i++) {
			cards[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(cards);
		
		long max = cards[0];
		int cnt = 1;
		int maxFreq = 1;
		
		for(int i = 1; i < n; i++) {
			
			if(cards[i] == cards[i - 1]) {
				cnt++;
			} else {
				cnt = 1;
			}
			
			if(cnt > maxFreq) {
				maxFreq = cnt;
				max = cards[i];
			}
		}
		
		System.out.println(max);
	}
}
