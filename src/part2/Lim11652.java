package part2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lim11652 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] cards = new long[n];
		
		for(int i = 0; i < n; i++) {
			cards[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(cards);
		
		long answer = cards[0];
		int cnt = 1;
		int max = 0;
		
		for(int i = 1; i < n; i++) {
			if(cards[i - 1] == cards[i]) {
				cnt++;
			} else {
				if(max < cnt) {
					max = cnt;
					answer = cards[i - 1];
				}
				
				cnt = 1;
			}
		}
		
		if(max < cnt) {
			answer = cards[n - 1];
		}
		
		System.out.println(answer);
	}
}
