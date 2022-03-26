package boj.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lim10815 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] cards = new int[N];
		
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		
		final int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < M; i++) {
			int candidate = Integer.parseInt(st.nextToken());
			
			boolean contains = search(candidate, cards, 0, cards.length - 1);
			
			if(contains) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb);
	}

	private static boolean search(int candidate, int[] cards, int start, int end) {
		
		if(start > end) return false;
		
		int mid = (start + end) / 2;
		boolean ret;
		
		if(cards[mid] == candidate) {
			ret = true;
		} else if(cards[mid] > candidate) {
			ret = search(candidate, cards, start, mid - 1);
		} else {
			ret = search(candidate, cards, mid + 1, end);
		}
		
		return ret;
	}
}
