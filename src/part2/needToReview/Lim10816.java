package part2.needToReview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lim10816 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n];
		int[] cardCnt = new int[20_000_001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			cardCnt[cards[i] + 10_000_000]++;
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			sb.append(cardCnt[target + 10_000_000] + " ");
		}
		
		System.out.println(sb);
	}
}
