package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim10815_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean[] cards = new boolean[20_000_001];
		
		for(int i = 0; i < N; i++) {
			cards[Integer.parseInt(st.nextToken()) + 10_000_000] = true;
		}
				
		final int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < M; i++) {
						
			if(cards[Integer.parseInt(st.nextToken()) + 10_000_000]) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb);
	}
}
